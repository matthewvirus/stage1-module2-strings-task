package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        List<MethodSignature.Argument> argumentList = new ArrayList<>();
        MethodSignature methodSignature;
        String[] signatureArray = signatureString.split("[(%)]");
        String[] mainSignatureArray = signatureArray[0].split(" ");
        String[] methodArgumentsArray;
        if (signatureArray.length == 2) {
            methodArgumentsArray = signatureArray[1].split(", ");
            for (String s : methodArgumentsArray) {
                argumentList.add(new MethodSignature.Argument(s.split(" ")[0], s.split(" ")[1]));
            }
        }
        methodSignature = new MethodSignature("", argumentList);
        if (mainSignatureArray.length == 3) {
            methodSignature.setAccessModifier(mainSignatureArray[0]);
            methodSignature.setReturnType(mainSignatureArray[1]);
            methodSignature.setMethodName(mainSignatureArray[2]);
        } else {
            methodSignature.setReturnType(mainSignatureArray[0]);
            methodSignature.setMethodName(mainSignatureArray[1]);
        }
        return methodSignature;
    }
}