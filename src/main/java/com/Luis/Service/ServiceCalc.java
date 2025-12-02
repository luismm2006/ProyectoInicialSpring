package com.Luis.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ServiceCalc {
	
	public int operation(Optional<String> sum1, Optional<String> sum2, Optional<String> operation) throws Exception {
		try {
			int n1 = Integer.parseInt(sum1.get());
			int n2 = Integer.parseInt(sum2.get());
			int result = 0;
			
			if(operation.get().equals("+")) {
				result = n1 + n2;
			}else if(operation.get().equals("-")) {
				result = n1 - n2;
			}else if(operation.get().equals("*")) {
				result = n1 * n2;
				
			}else if(operation.get().equals("/")) {
				if(n2 != 0) {
					result = n1 / n2;
				}else {
					throw new Exception("");
				}
			}
			return result;
		} catch (Exception e) {
			throw new Exception("");
		}
	}
}
