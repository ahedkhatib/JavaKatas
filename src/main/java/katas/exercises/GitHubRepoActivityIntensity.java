package katas.exercises;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

import java.util.Collections;
import java.util.List;


public class GitHubRepoActivityIntensity {
    /**
     * Analyze the activity level of a specific GitHub repository.
     *
     * Calculate the average time (in hours) between commits in a given GitHub repository.
     *
     * Use the GitHub API to:
     *
     *     - Fetch commit timestamps for a given repository (paginate to fetch ALL commits!!!)
     *     - Calculate the average time (in hours) between consecutive commits.
     *
     * Use the GitHub REST API to fetch commit data for a repository.
     * The API endpoint is: GET https://api.github.com/repos/{owner}/{repo}/commits
     *
     *
     * Note: the unittest for this kata is partially implemented under `GitHubRepoActivityIntensityTest`.
     */

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos";

    /**
     * Fetches commit timestamps for the specified repository using the GitHub API.
     *
     * @param owner the owner of the repository
     * @param repo the name of the repository
     * @return a list of commit timestamps as Instant objects
     * @throws Exception if there is an error fetching or parsing the data
     */
    public static List<Instant> fetchCommitTimestamps(String owner, String repo) throws Exception {
        // example:
        URL url = new URL(GITHUB_API_BASE_URL + "%s/" + owner + "%s/" + repo );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/vnd.github+json");
        return null; //I added
    }

    /**
     * Calculates the average time between consecutive commits.
     *
     * @param timestamps a list of commit timestamps
     * @return the average time in hours
     */
    public static double calculateAverageTimeBetweenCommits(List<Instant> timestamps) {
        if (timestamps == null || timestamps.size() <= 1){
            return 0.0;
        }
        Collections.sort(timestamps);
        double totalHours = 0.0;
        for(int i = 1; i < timestamps.size(); i++){
            Duration duration = Duration.between(timestamps.get(i),timestamps.get(i-1));
            totalHours += Math.abs(duration.toHours());
        }

        return totalHours / (timestamps.size() - 1);
    }

    public static void main(String[] args) {
        try {
            List<Instant> timestamps = fetchCommitTimestamps("torvalds", "linux");
            double avgTime = calculateAverageTimeBetweenCommits(timestamps);

            System.out.printf("The average time between commits in the repository is %.2f hours.%n", avgTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


