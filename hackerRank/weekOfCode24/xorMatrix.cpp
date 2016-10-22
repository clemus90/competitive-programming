//NOT FOR ALL TEST CASES
#include <iostream>
#include <climits>
using namespace std;

int main() {
  long i, j, partial, factor, count, pos;
  long n, m;
  cin >> n >> m;
  long firstRow[n];
  bool xorIncluded[n];

  for(i=0; i<n; i++){
    cin >> firstRow[i];
  }

  for(i=0; i<n; i++){
    xorIncluded[i] = false;
    factor = 0;
    count = 0;
    pos = i;
    while(pos < m){
      if((pos & ((m-1)-pos)) == 0){
        count++;
      }
      factor++;
      pos = i + (n * factor);
    }
    if(count % 2 == 1){
      xorIncluded[i] = true;
    }
  }

  for(i=0; i<n; i++){
    partial = 0;
    for(j=0; j<n; j++){
      if(xorIncluded[j]){
        partial = partial ^ firstRow[(i+j)%n];
      }
    }
    cout << partial;
    if(i != n-1){
      cout << " ";
    }
  }
  cout << '\n';
}