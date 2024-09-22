//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1?page=1&category=Greedy&sortBy=submissions
//
//There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
//What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
//
//Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
//
//
//Example 1:
//
//Input:
//N = 6
//start[] = {1,3,0,5,8,5}
//end[] =  {2,4,6,7,9,9}
//Output:
//4
//Explanation:
//Maximum four meetings can be held with
//given start and end timings.
//The meetings are - (1, 2),(3, 4), (5,7) and (8,9)


//Tc:- O(N log N);
//    N log N for sorting
//Sc:- O(N)

