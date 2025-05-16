package com.startup.humanresourcescrm.util;

import com.startup.humanresourcescrm.repository.ParamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CodeParam {
    ParamRepository paramRepository;

    public String generate() {
        String lastCode = paramRepository.findLastCode();

        int nextNumber = 1;
        if (lastCode != null && lastCode.startsWith("P")) {
            int lastNumber = Integer.parseInt(lastCode.substring(1));
            nextNumber = lastNumber + 1;
        }

        return String.format("P%03d", nextNumber);
    }
}
