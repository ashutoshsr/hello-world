package quizez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100005
 * 0 ≤ A[i] ≤ 100005
 * 1 ≤ k ≤ 100005
 */
public class SortedRotatedArray {
    public static void main(String[] args) {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();

        long currentTime = System.currentTimeMillis();
        Callable task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    int inputIndex = 0;
                    String tempInput = "";
                    while (inputIndex < 5 || (System.currentTimeMillis() - currentTime) < 1500) {
                        inputIndex++;
                        tempInput = consoleInput.readLine();
                        System.out.println(tempInput);
                        if (!tempInput.isEmpty()) {
                            inputList.add(tempInput);
                        }

                    }
                } catch (IOException e) {
                }
                return null;
            }
        };
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<String> result = ex.submit(task);
        try {
            result.get(4000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            result.cancel(true);
            int actualLengthOfInput = inputList.size();
            String[] numbers = null;
            int numberToFind = -1;
            String currentString = null;

            if (actualLengthOfInput != 0) {
                currentString = inputList.get(actualLengthOfInput-- - 1);
                if (!currentString.isEmpty()) {
                    numberToFind = Integer.parseInt(currentString);
                } else {
                    System.out.println(-1);
                    System.exit(0);
                }
            }

            if (actualLengthOfInput != 0) {
                currentString = inputList.get(actualLengthOfInput-- - 1);
                if (!currentString.isEmpty()) {
                    numbers = currentString.split(" ");
                } else {
                    System.out.println(-1);
                    System.exit(0);
                }
            }

            int lenghtOfInputArray = -1;

            if (actualLengthOfInput != 0) {
                currentString = inputList.get(actualLengthOfInput-- - 1);
                if (!currentString.isEmpty()) {
                    lenghtOfInputArray = Integer.parseInt(currentString);
                    if (lenghtOfInputArray <= 0 || lenghtOfInputArray > 100005) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }

            int testCases = 1;
            if (actualLengthOfInput != 0) {
                currentString = inputList.get(actualLengthOfInput-- - 1);
                if (!currentString.isEmpty()) {
                    testCases = Integer.parseInt(currentString);
                    if (testCases < 0 || testCases > 100) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }

            for (int j = 0; j < numbers.length; j++) {
                if (Integer.parseInt(numbers[j]) == numberToFind) {
                    System.out.println(j);
                }
            }
        }
    }
}