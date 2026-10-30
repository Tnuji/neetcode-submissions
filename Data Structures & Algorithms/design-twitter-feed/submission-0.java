class Twitter {

    private static class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId, int time)
        {
            this.tweetId = tweetId;
            this.time = time;
        }

    }

    HashMap<Integer , Set<Integer>> following;
    HashMap<Integer, List<Tweet>> tweets;
    private int timestamp;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;    
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId , new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId , timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> max = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        Set<Integer> users = new HashSet<>();

        users.add(userId);

        users.addAll(following.getOrDefault(userId, new HashSet<>()));

        for (int user : users) {
            List<Tweet> userTweets = tweets.get(user);

            if (userTweets != null) {
                for (Tweet tweet : userTweets) {
                    max.offer(tweet);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!max.isEmpty() && result.size() < 10) {
            result.add(max.poll().tweetId);
        }

        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
