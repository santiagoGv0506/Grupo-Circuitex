#include <tchar.h>
#include <locale.h>
#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#define ARRAY_MIN (1024) 
#define ARRAY_MAX (4096*4096)
int x[ARRAY_MAX]; /
#ifdef _MSC_VER
double get_seconds() { 
 __time64_t ltime;
 _time64(&ltime);
 return (double) ltime;
}
#else
double get_seconds() {
 struct timeval tv;
 gettimeofday(&tv, NULL);
return tv.tv_sec + tv.tv_usec / 1e6;}
#endif
int label(int i) { 
 if (i < 1e3) printf("%1dB,", i);
 else if (i < 1e6) printf("%1dK,", i / 1024);
 else if (i < 1e9) printf("%1dM,", i / 1048576);
 else printf("%1dG,", i / 1073741824);
 return 0;
}
void dummy_function(int steps) {
 volatile int dummy = 0;
 for (int i = 0; i < steps; ++i) {
 dummy += i;
 }
}
#ifdef _MSC_VER
int _tmain(int argc, _TCHAR* argv[]) {
#else
int main(int argc, char* argv[]) {
#endif
int register nextstep, i, index, stride;
 int register csize;
 double steps, tsteps;
 double loadtime, lastsec, sec0, sec1, sec; 
 
 printf(" ,");
 for (stride = 1; stride <= ARRAY_MAX / 2; 
stride = stride * 2)
 label(stride * sizeof(int));
 printf("\n");
 for (csize = ARRAY_MIN; csize <= 
ARRAY_MAX; csize = csize * 2) {
 label(csize * sizeof(int)); /* print cache size this 
loop */
 for (stride = 1; stride <= csize / 2; stride = stride 
* 2) {
 /* Lay out path of memory references in array 
*/
 for (index = 0; index < csize; index = index + 
stride)
 x[index] = index + stride; /* pointer to next */
 x[index - stride] = 0; /* loop back to beginning 
*/
 lastsec = get_seconds();
 do sec0 = get_seconds(); while (sec0 == 
lastsec);
 steps = 0.0; 
 nextstep = 0; 
 sec0 = get_seconds(); 
 do { 
 for (i = stride; i != 0; i = i - 1) { 
 nextstep %= csize;
 do nextstep = x[nextstep]; 
 while (nextstep != 0);
 }
 steps = steps + 1.0; 
 sec1 = get_seconds(); 
 } while ((sec1 - sec0) < 20.0); 
 sec = sec1 - sec0;
 tsteps = 0.0; 
 index = 0; 
 sec0 = get_seconds(); 
 do { 
 for (i = stride; i != 0; i = i - 1) { 
 index %= csize;
 do index = index + stride;
 while (index < csize);
}
 tsteps = tsteps + 1.0;
 sec1 = get_seconds(); 
 } while (tsteps < steps); 
 sec = sec - (sec1 - sec0);
 loadtime = (sec * 1e9) / (steps * csize);
 /* write out results in .csv format for Excel */
 printf("%4.1f,", (loadtime < 0.1) ? 0.1 : 
loadtime);
 }
 printf("\n");
 }
 printf("Instruction Cache,\n");
 for (csize = ARRAY_MIN; csize <= 
ARRAY_MAX; csize = csize * 2) {
 label(csize * sizeof(int)); 
 for (stride = 1; stride <= csize / 2; stride = stride 
* 2) {
 steps = 0.0;
 sec0 = get_seconds();
 do {
 for (i = 0; i < stride; ++i) {
 dummy_function(csize);
 }
 steps = steps + 1.0;
 sec1 = get_seconds();
 } while ((sec1 - sec0) < 20.0);
 sec = sec1 - sec0;
 tsteps = 0.0;
 sec0 = get_seconds();
 do {
 for (i = 0; i < stride; ++i) {
 }
 tsteps = tsteps + 1.0;
 sec1 = get_seconds();
 } while (tsteps < steps);
 sec = sec - (sec1 - sec0);
 loadtime = (sec * 1e9) / (steps * csize);
 printf("%4.1f,", (loadtime < 0.1) ? 0.1 : 
loadtime);
 }
 printf("\n");
 }
 char varfin[100];
 fgets(varfin, 100, stdin);
 return 0;
}