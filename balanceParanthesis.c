#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node {
    char data;
    struct node* next;
}stk;
int checkPair(char c, char c1)
{
    if(c=='{' && c1=='}')
        return 1;
    if(c=='[' && c1==']')
        return 1;
    if(c=='(' && c1==')')
        return 1;
    return 0;
}
void push(stk** stack,char c)
{
    stk* nn = (stk*)malloc(sizeof(stk));
    nn->data = c;
    nn->next = *stack;
    *stack = nn;
}
char pop(stk** stack){
    char c;
    stk* temp = (stk*)malloc(sizeof(stk));
    temp->data = (*stack)->data;
    temp->next = (*stack)->next;
    *stack = (*stack)->next;
    c = temp->data;
    free(temp);
    return c;
}
char* isBalanced(char* s) {
    int i = 0;
    int res;
    char x;
    stk* stack = (stk*)malloc(sizeof(stk*));
    stack = NULL;
    char *str1 = "NO";
    char *str2 = "YES";
    while(s[i]!='\0') {
        if(s[i]=='{' || s[i]=='[' || s[i]=='(')
            push(&stack , s[i]);
        else if(s[i]=='}' || s[i]==']' || s[i]==')') {
            if(stack == NULL)
                return str1;
            x = pop(&stack);
            res = checkPair(x,s[i]);
            if(!res)
                return str1;
        }
        i++;
    }
    if(stack == NULL)
        return str2;
    return str1;
}

