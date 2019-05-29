#include <bits/stdc++.h>

using namespace std;

int hourglassSum(vector<vector<int>> arr) {
  int max = INT_MIN;
  int kernel[3][3] = { 1, 1, 1, 0, 1, 0, 1, 1, 1};

  for (int y = 0; y < 4; y++) {
    for (int x = 0; x < 4; x++) {
        int sum = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                sum += arr[y+i][x+j] * kernel[i][j];
            }
        }
          
        if (max < sum) {
            max = sum;
        }
    }
  }

  return max;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = hourglassSum(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
