package quizez;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SortedRotatedArrayOne {
    public static void main(String[] args) {
        final BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        final List<String> inputList = new ArrayList<>();

        final Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String line = "";
                while (!Thread.currentThread().isInterrupted()) {
                    if ((line = consoleInput.readLine()) !=null) {
                        if (line.isEmpty()) {
                            throw new TimeoutException("");
                        } else {
                            inputList.add(line);
                        }
                    }
                }
                return null;
            }
        };
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<String> result = ex.submit(task);
        try {
            result.get(550, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        } catch (ExecutionException ee) {
        } catch (TimeoutException te) {
            result.cancel(true);
        } finally {
            evaluateInput(inputList);
        }
    }

    private static void evaluateInput(List<String> inputList) {
        int actualLengthOfInput = inputList.size();
        String[] numbers = null;
        int numberToFind = -1;
        boolean found = false;
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
                found = true;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
        System.exit(0);
    }
}