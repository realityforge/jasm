/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/mman.h>
#include <errno.h>

#define MAP_ADDRESS ((void *)0x5B000000)

typedef int (*myFuncDef)();
static myFuncDef f = (myFuncDef)MAP_ADDRESS;

static int pageRoundUp(int size)
{
    int pageSize = 4096;
    return (size + pageSize - 1) / pageSize * pageSize;
}

/*
 * Simple program that loads file passed as arg, assumes it is
 * code read to be mapped to MAP_ADDRESS, maps it and then executes
 * code.
 */
int main(int argc, char** argv)
{
  struct stat stats;
  char *pFilename;
  int fd;
  void *result;

  if( 2 != argc )
  {
    printf("Program accepts 1 arg: name of code file to load\n");
    return 1;
  }

  pFilename = argv[1];
  printf("Loading %s\n", pFilename);

  if( -1 == stat(pFilename, &stats) )
  {
    perror("stat");
    return 1;
  }

  fd = open(pFilename, O_RDONLY);
  if( -1 == fd )
  {
    perror("open");
    return 1;
  }

  result = mmap(MAP_ADDRESS,
                pageRoundUp(stats.st_size),
                PROT_READ | PROT_WRITE | PROT_EXEC,
		            MAP_FILE | MAP_FIXED | MAP_PRIVATE | MAP_NORESERVE,
		            fd,
		            0);
  if( MAP_ADDRESS != result )
  {
    perror("mmap");
    return 1;
  }
  printf("Result of running compiled code: %d\n", f());

  close(fd);
  return 0;
}
