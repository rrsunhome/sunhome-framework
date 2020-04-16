package com.sunhome.framework.generic.inferace;

public interface Converter<S, T> {

    T convert(S s);


    public static class StringConverter<S> implements Converter<S, String> {

        @Override
        public String convert(S s) {
            return String.valueOf(s);
        }
    }

    public static class IntegerToStringConverter implements Converter<Integer, String> {

        @Override
        public String convert(Integer s) {
            return String.valueOf(s);
        }
    }

    public static class ObjectConverter<S, T> implements Converter<S, T> {

        @Override
        public T convert(S s) {
            return (T) String.valueOf(s);
        }
    }

    public static void main(String[] args) {
        StringConverter<Integer> stringConverter = new StringConverter();
        String value = stringConverter.convert(1);
        System.out.println(value);

        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        System.out.println(integerToStringConverter.convert(12));

        ObjectConverter<Integer, String> objectConverter = new ObjectConverter<Integer, String>();
        System.out.println(objectConverter.convert(1));

    }


}
