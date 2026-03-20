/*
	통나무 자르기 문제와 비슷한 유형이다.
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int BinarySearch(vector<long long> v, long long target){
	long long start = 1;
	long long end = v[0];	// 가장 큰 사이즈의 랜선을 end에 저장
	long long answer = 0;
	
	while(start <= end){
		long long sumNum = 0;	// 랜선의 총 개수의 합이다.
		long long midSize = (start + end) / 2;
		
		for(int i = 0; i < v.size(); i++){
			sumNum+=(v[i]/midSize);	// 자른 개수만큼 sum에 더해줌.
			// if(midSize > v[i]) break;	// 자를 사이즈가 더 큰 경우에는 할 필요가 없다.
		}
		if(sumNum >= target){
			start = midSize+1;
			if(midSize >= answer){
				answer = midSize;
			}
		}
		else{
			end = midSize-1;
		}		
	}
	return answer;
}

int main(){
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	
	long long target, n;
	cin >> n >> target;
	vector<long long> v;
	
	for(int i = 0; i < n; i++){
		long long size;
		cin >> size;
		v.push_back(size);
	}
	
	sort(v.begin(), v.end(), greater<long long>());	// 내림차순으로 정렬
		
	cout << BinarySearch(v, target);
}


/*
	문제를 풀고 나서 알게 된 것인데 max 함수가 있다.
	algorithm 헤더에 존재한다.
	std::max(a,b) - a,b의 값을 비교해서 큰값을 반환하는 함수다.
	이를 쓰면 굳이 if문으로 더럽게 쓰지 않아도  된다.
*/