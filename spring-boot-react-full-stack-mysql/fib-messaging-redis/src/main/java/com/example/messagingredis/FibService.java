package com.example.messagingredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FibService {
    @Autowired
    FibRepository fibRepository;

    HashMap<Integer, Integer> fibMap = new HashMap<>();

    public void calculateAndStore(Integer index) {
        FibStore<Integer, Integer> fibStore = new FibStore();
        fibStore.setKey(index);
        fibStore.setValue(fib(index));
        fibRepository.save(fibStore);
    }

    private Integer fib(int number) {
        if (number == 0) return 0;
        if (number < 2) return 1;

        if (fibMap.containsKey(number)) {
            return fibMap.get(number);
        }
        int result = fib(number - 1) + fib(number - 2);

        fibMap.put(number, result);
        return result;

    }

   /* public static void main(String[] args) {
        System.out.println(new FibService().calculateFib(7));
    }*/

}
