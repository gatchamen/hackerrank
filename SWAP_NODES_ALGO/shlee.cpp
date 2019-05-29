#include <bits/stdc++.h>

using namespace std;

void dfs(const vector<vector<int>>& indexes, vector<int>& inorder, int current, int depth, const vector<int>& mask) {
    const int left = indexes[current-1][0];
    const int right = indexes[current-1][1];

    if (mask[depth] == 1) {
      if (right != -1) {
        dfs(indexes, inorder, right, depth + 1, mask);
      }
      inorder.push_back(current);
      if (left != -1) {
        dfs(indexes, inorder, left, depth + 1, mask);
      }
    } else {
      if (left != -1) {
        dfs(indexes, inorder, left, depth+1, mask);
      }
      inorder.push_back(current);
      if (right != -1) {
        dfs(indexes, inorder, right, depth+1, mask);
      }
    }
}

    /*
     * Complete the swapNodes function below.
     */
vector<vector<int>> swapNodes(vector<vector<int>> indexes,
                                  vector<int> queries) {
  vector<vector<int>> solution;
  vector<int> mask(1025);

  for (int q : queries) {
    for(int k=q; k <= 1024; k +=q) {
        mask[k] = !mask[k];
    }
    vector<int> inorder;
    dfs(indexes, inorder, 1, 1, mask);
    solution.push_back(inorder);
  }

  return solution;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<vector<int>> indexes(n);
    for (int indexes_row_itr = 0; indexes_row_itr < n; indexes_row_itr++) {
        indexes[indexes_row_itr].resize(2);

        for (int indexes_column_itr = 0; indexes_column_itr < 2; indexes_column_itr++) {
            cin >> indexes[indexes_row_itr][indexes_column_itr];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int queries_count;
    cin >> queries_count;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<int> queries(queries_count);

    for (int queries_itr = 0; queries_itr < queries_count; queries_itr++) {
        int queries_item;
        cin >> queries_item;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        queries[queries_itr] = queries_item;
    }

    vector<vector<int>> result = swapNodes(indexes, queries);

    for (int result_row_itr = 0; result_row_itr < result.size(); result_row_itr++) {
        for (int result_column_itr = 0; result_column_itr < result[result_row_itr].size(); result_column_itr++) {
            fout << result[result_row_itr][result_column_itr];

            if (result_column_itr != result[result_row_itr].size() - 1) {
                fout << " ";
            }
        }

        if (result_row_itr != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

