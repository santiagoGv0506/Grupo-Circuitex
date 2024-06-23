#include <tchar.h>
#include <locale.h>
#include <stdio.h>
#include <time.h>
#include <sys/time.h>


#define ARRAY_MIN (1024) /* 1/4 smallest cache */
#define ARRAY_MAX (4096*4096) /* 1/4 largest cache */

int x[ARRAY_MAX]; /* array going to stride through */

double get_seconds() {
    __time64_t ltime;
    _time64(&ltime);
    return (double) ltime;
}

int label(int i) {
    if (i < 1e3) printf("%1dB,", i);
    else if (i < 1e6) printf("%1dK,", i / 1024);
    else if (i < 1e9) printf("%1dM,", i / 1048576);
    else printf("%1dG,", i / 1073741824);
    return 0;
}

void sequence1(int size) {
    int i, sum = 0;
    for (i = 0; i < size; i++) {
        sum += x[i];
    }
}

void sequence2(int size) {
    int i, sum = 0;
    for (i = size - 1; i >= 0; i--) {
        sum += x[i];
    }
}

void sequence3(int size, int stride) {
    int i, sum = 0;
    for (i = 0; i < size; i += stride) {
        sum += x[i];
    }
}

int _tmain(int argc, _TCHAR* argv[]) {
    int stride, csize, index;
    double loadtime, lastsec, sec0, sec1, sec, steps, tsteps;

    printf(" ,");
    for (stride = 1; stride <= ARRAY_MAX / 2; stride = stride * 2) label(stride * sizeof(int));
    printf("\n");

    for (csize = ARRAY_MIN; csize <= ARRAY_MAX; csize = csize * 2) {
        label(csize * sizeof(int));

        for (stride = 1; stride <= csize / 2; stride = stride * 2) {
            for (index = 0; index < csize; index = index + stride)
                x[index] = index + stride;
            x[index - stride] = 0;

            lastsec = get_seconds();
            sec0 = get_seconds();
            while (sec0 == lastsec) sec0 = get_seconds();

            steps = 0.0;
            sec0 = get_seconds();

            do {
                sequence1(csize);
                steps += 1.0;
                sec1 = get_seconds();
            } while ((sec1 - sec0) < 20.0);

            sec = sec1 - sec0;

            tsteps = 0.0;
            sec0 = get_seconds();

            do {
                sequence1(csize);
                tsteps += 1.0;
                sec1 = get_seconds();
            } while (tsteps < steps);

            sec = sec - (sec1 - sec0);
            loadtime = (sec * 1e9) / (steps * csize);
            printf("%4.1f,", (loadtime < 0.1) ? 0.1 : loadtime);
        }
        printf("\n");
    }

    return 0;
}