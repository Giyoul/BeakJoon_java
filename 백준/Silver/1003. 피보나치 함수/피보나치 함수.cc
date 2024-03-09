/*
	규칙을 찾아보니,
	N	/	0	/	1
	0		1		0
	1		0		1
	2		1		1
	3		1		2
	4		2		3
	5		3		5
	6		5		8
	이다.
	음.
	0이 1보다 하나 늦게 나오는게 같다.
	
	N <= 40 이니까 40까지만 fib의 값을 구해주면 되겠다. 그러면 1의 값을 41까지 구해주고 0은 index가 하나 더 많은 거로 출력해주면 되겠다.
*/

#include <iostream>
using namespace std;

int main(){
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	
	int N, T;
	int fibArr[41] = {0, 1};	// 처음 두 개의 수만 써주면 뒤에는 다 구할 수 있다. 41까지 해준다.
	
	cin >> N;
	
	for(int i = 0; i < 40; i++){
		fibArr[i+2] = fibArr[i] + fibArr[i+1];
	}
	
	for(int i = 0; i < N; i++){
		cin >> T;
		if(T == 0){
			cout << "1 0\n";
		}
		else{
			cout << fibArr[T-1] << ' ' << fibArr[T] << '\n';
		}
	}
}
