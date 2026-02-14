1class Twitter {
2   static int time;
3   // userId -> set of followees
4     HashMap<Integer, Set<Integer>> followMap;
5
6    // userId -> list of tweets
7     HashMap<Integer, List<Tweet>> tweetMap;
8
9     static class Tweet{
10        int tweetId;
11        int time;
12        Tweet(int tweetId, int time) {
13            this.tweetId = tweetId;
14            this.time = time;
15        }
16     }
17    public Twitter() {
18        time = 0;
19        followMap = new HashMap<>();
20        tweetMap = new HashMap<>();
21    }
22    public void postTweet(int userId, int tweetId) {
23        tweetMap.putIfAbsent(userId,new ArrayList<>());
24        tweetMap.get(userId).add(new Tweet(tweetId,time++));
25    }
26    
27    public List<Integer> getNewsFeed(int userId) {
28        List<Integer> result = new ArrayList<>();
29
30        // Max heap based on time
31        PriorityQueue<Tweet> pq =
32            new PriorityQueue<>((a, b) -> b.time - a.time);
33
34            // User should see their own tweets
35        followMap.putIfAbsent(userId,new HashSet<>());
36        followMap.get(userId).add(userId);
37
38        // Add tweets of all followees
39        for(int followee:followMap.get(userId)){
40            if(tweetMap.containsKey(followee)){
41                for(Tweet t:tweetMap.get(followee)){
42                    pq.add(t);
43                }
44            }
45        }
46
47        // Get top 10 tweets
48        while (!pq.isEmpty() && result.size() < 10) {
49            result.add(pq.poll().tweetId);
50        }
51
52        return result;
53    }
54    
55    public void follow(int followerId, int followeeId) {
56        followMap.putIfAbsent(followerId, new HashSet<>());
57        followMap.get(followerId).add(followeeId);
58    }
59    
60    public void unfollow(int followerId, int followeeId) {
61        if (followMap.containsKey(followerId) && followerId != followeeId) {
62            followMap.get(followerId).remove(followeeId);
63        }
64    }
65}
66
67/**
68 * Your Twitter object will be instantiated and called as such:
69 * Twitter obj = new Twitter();
70 * obj.postTweet(userId,tweetId);
71 * List<Integer> param_2 = obj.getNewsFeed(userId);
72 * obj.follow(followerId,followeeId);
73 * obj.unfollow(followerId,followeeId);
74 */