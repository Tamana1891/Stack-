#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct stack
{
    int data;
    struct stack *next;
}stack;

stack* create(int data)
{
    stack *nn = (stack*)malloc(sizeof(stack*));
    nn->data = data;
    nn->next = NULL;
    return nn;
}

void push(stack **h,int data)
{
    stack* nn = create(data);
    nn->next = *h;
    *h = nn;
}

int isEmpty(stack *h)
{
    return !h;
}

void pop(stack **h)
{
    if(isEmpty(*h))
            return ;
    stack *temp = *h;
    *h = (*h)->next;
    free(temp);
}

int top(stack *h) {
    if(isEmpty(h))
        return INT_MIN;
    return h->data;
}

long largestRectangle(int h_count, int* h) {
    stack *stk = NULL;
    long long int max_area = 0;
    int tp;
    int area_with_top;
    
    int i=0;
    while(i<h_count)
    {
        if(isEmpty(stk) || h[top(stk)] <= h[i])
            push(&stk , i++);
        else
        {
            tp = top(stk);
            pop(&stk);
            area_with_top = h[tp] * (isEmpty(stk) ? i : i-top(stk)-1);
            
            if(max_area < area_with_top)
                max_area = area_with_top;
        }
    }
    while(isEmpty(stk) == false)
    {
        tp = top(stk);
            pop(&stk);
            area_with_top = h[tp] * (isEmpty(stk) ? i : i-top(stk)-1);
            
            if(max_area < area_with_top)
                max_area = area_with_top;
    }
return max_area;
}