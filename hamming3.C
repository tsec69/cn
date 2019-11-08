#include<stdio.h>
int main(){
int dest[7],bits[7],i,j;
int pos1,pos2,pos3,pos;
printf("\nEnter the hamming code: ");
scanf("%d%d%d%d",&bits[0],&bits[1],&bit
s[2],&bits[4]);
bits[6]=bits[0]^bits[2]^bits[4];
bits[5]=bits[0]^bits[1]^bits[4];
bits[3]=bits[0]^bits[1]^bits[3];
printf("\nEnter the bit at which you want to
introduce the error: ");
scanf("%d",&j);
printf("\nThe Encoded bits are: ");
for(i=0;i<7;i++){
printf("%d",bits[i]);
}
printf("\nEnter the received bits: ");
for(i=0;i<7;i++){
scanf("%d",&dest[i]);
}
pos1=dest[0]^dest[2]^dest[4]^dest[6];
pos2=dest[0]^dest[1]^dest[4]^dest[5];
pos3=dest[0]^dest[1]^dest[2]^dest[3];
pos=pos3*4+pos2*2+pos1;
printf("\nThe Parity of 1: %d",pos1);
printf("\nThe Parity of 2: %d",pos2);
printf("\nThe Parity of 4: %d",pos3);
if(pos==0){
printf("\nError is not present");
}
else{
printf("\nThis code contains error at
position: %d",pos);
if(dest[7-pos]==0){
dest[7-pos]=1;

}
else{
dest[7-pos]=0;
}
printf("\nThe Correct message is:");
for(i=0;i<7;i++){
printf("%d",dest[i]);
}
printf("\n");
}
}

/*OUTPUT:
Enter the hamming code: 1
1
0
1
Enter the bit at which you want to
introduce the error: 2
The Encoded bits are: 1100110
Enter the received bits: 0
1
0
0
1
1
0
The Parity of 1: 1
The Parity of 2: 1
The Parity of 4: 1
This code contains error at position: 7
The Correct message is:1100110
*/