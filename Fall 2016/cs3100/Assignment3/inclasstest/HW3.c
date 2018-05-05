#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>



int main(){
	int data_processed;
	int file_pipes[2];
	const char some_data[] = "123";
	char buffer[BUFSIZ + 1];
	pid_t fork_result;

	memset(buffer, "\0", sizeof(buffer));


	if (pipe(file_pipes) == 0) { 
		fork_result = fork(); 
		if (fork_result == (pid_t)-1) { 
			fprintf(stderr, "Fork failure"); 
			exit(EXIT_FAILURE); 
		}

		if (fork_result == (pid_t)0) { 
			close(0); 
			dup(file_pipes[0]); 
			close(file_pipes[0]);
			close(file_pipes[1]);
			sprintf(buffer, "%d", file_pipes[0]); 
			(void)execl("od", "od", "-c", (char *)0); 
			exit(EXIT_FAILURE);
		}
		else { 
			close(file_pipes[0]); 
			data_processed = write(file_pipes[1], some_data, strlen(some_data)); 
			close(file_pipes[1]); 
			printf("%d - wrote %d bytes\n", (int)getpid(), data_processed); 
		}	
		/*
		if (fork_result == 0) { 
			sprintf(buffer, "%d", file_pipes[0]); 
			(void)execl("minmax", "minmax", buffer, (char *)0); 
			exit(EXIT_FAILURE); 
		} 
		else { 
			data_processed = write(file_pipes[1], some_data, strlen(some_data)); 
			printf("%d - wrote %d bytes\n", getpid(), data_processed); 
		}
		*/
	} 
	exit(EXIT_SUCCESS);
}



/*
int main() {
	int data_processed; 
	int file_pipes[2]; 
	const char some_data[] = "123"; 
	char buffer[BUFSIZ + 1]; 
	pid_t fork_result;
	memset(buffer, "\0", sizeof(buffer));
	if (pipe(file_pipes) == 0) { 
		fork_result = fork(); 
		if (fork_result == (pid_t)-1) { 
			fprintf(stderr, "Fork failure"); 
			exit(EXIT_FAILURE); 
		}
		if (fork_result == 0) { 
			sprintf(buffer, "%d", file_pipes[0]); 
			(void)execl("minmax", "minmax", buffer, (char *)0); 
			exit(EXIT_FAILURE); 
		} 
		else { 
			data_processed = write(file_pipes[1], some_data, strlen(some_data)); 
			printf("%d - wrote %d bytes\n", getpid(), data_processed); 
		}
	} 
	exit(EXIT_SUCCESS);

	*/



