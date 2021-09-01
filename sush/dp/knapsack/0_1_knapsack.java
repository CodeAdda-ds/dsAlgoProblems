Consider a basic problem where we have weights and profits of items and we have to maximise profit

We will have 2 choices per item so 2^N combinations in total

when to choose or skip?

if weight of ith item = wi

bag has (space + filled) == total space of bag == W
space == total capacity - filled capacity


if wi > space --> exclude the item
if wi <= space --> max(included case, excluded case)


-----------------------------------------------------------------------------------------------

Recursion structure

ReturnType Knapsack(Input)
{
	1. base condition
	2. decision tree diagram
}

base condition:

if ( space == 0 || noOfItems == 0 ) return 0;

thinking recursion:

right to left ja rahe hain for weight array
items = n
space left = w

initial i/p (weight[], profit[], wn, n)

for every ith item, we either include or exclude it
include ke liye input --> (weight, profit, W - wi, n-1)
exclude ke liye input --> (weight, profit, W, n-1)


--------------------------------------------------------------------------------------------------

Code structure 

int knapsack( int weight[], int profit[], int W, int N)
{
	// base case
	if(N==0 || W==0)
		return 0;
	
	// skip case
	if(weight[N] > W)
		return knapsack(weight, profit, W, N-1);
	else
		return max(profit[N] + knapsack(weight, profit, W-wi, N-1), knapsack(weight, profit, W, N-1));
}

Time complexity: 2^N

---------------------------------------------------------------------------------------------------

0-1 knapsack using memoization

int knapsack( int weight[], int profit[], int W, int N)
{
	// base case
	if(N==0 || W==0)
		return 0;
	
	// lookup 
	if(mem[W][N]!=-1) return mem[W][N];

	int result;
	// skip case
	if(weight[N] > W)
		result = knapsack(weight, profit, W, N-1);
	else
		result = max(profit[N] + knapsack(weight, profit, W-wi, N-1), knapsack(weight, profit, W, N-1));
		// update table
		mem[W][N] = result;
}

Memoization problems:

extra space and stack overflow
recursive approach will take more time than recursive approach

Time complexity: O (N.W)

--------------------------------------------------------------------------------------------------

0-1 knapsack using tabulation

Recursion: func calls
Memoization: func calls + table
Tabulation: table

Heap memory available is much greater than the stack memory, hence we should make use of heap memory

Building table:
max profit depends upon two things, these are our states
No of states = 2
Table size: dp[N+1][W+1] 0 to N, 0 to W 

The value in the last cell of the dp table will be our answer
Identify the subproblems:
Write the recursive solution first and convert it into the tabular approach

Code:


int knapsack(int weight[], int profit[], int W, int N)
{
	for(int i=0; i<=N; i++)
	   for(int j=0; j<=W; j++)
		// base case
		if(i==0 || j==0) dp[i][j] = 0;

		else if (weight[i-1] > j) dp[i][j] = dp[i-1][j]; // we are excluding it

		else dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][W-weight[i-1]]);
	

}

Time complexity: O(N.W)
