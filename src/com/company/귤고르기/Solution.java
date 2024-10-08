package com.company.귤고르기;

import java.util.*;

/*
경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.

예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다.
경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution {
    /*
    [1, 3, 2, 5, 4, 5, 2, 3]
    1 -> 1개
    2 -> 2개
    3 -> 2개
    4 -> 1개
    5 -> 2개

    배열 돌면서 새로운 배열을 만들고, 귤크 크기를 자리수로 정하고,
    정렬하고
    앞에서부터 개수 세면 될듯?
    */
    public static int solution(int k, int[] tangerine) {

        Map<Integer, Integer> tangerineCount = new HashMap<>();

        for (int t : tangerine) {
            tangerineCount.put(t, tangerineCount.getOrDefault(t,0) +1);
        }
        List<Integer> counts = new ArrayList<>(tangerineCount.values());//1,2,2,1,2
        counts.sort(Collections.reverseOrder());//2,2,2,1,1

        int count = 0, answer = 0;
        for (int c : counts) {
            count += c;
            answer++;
            System.out.println(count);
            if (count >= k) {
                return answer;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        Solution.solution(1, new int[]{1});
        Solution.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }
}
