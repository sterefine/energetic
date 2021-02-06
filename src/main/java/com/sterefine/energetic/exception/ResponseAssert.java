package com.sterefine.energetic.exception;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface ResponseAssert {

    Class<? extends RuntimeException> getExceptionType();

    default void notNull(@Nullable Object object, int code, String message) {
        if (object == null) {
            newException(code, message);
        }
    }

    default void notNull(@Nullable Object object, String message) {
        if (object == null) {
            newException(message);
        }
    }

    default void notNull(@Nullable Object object ) {
        if (object == null) {
            newException();
        }
    }

    default void notEmpty(@Nullable Collection<?> collection, int code, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            newException(code, message);
        }
    }

    default void notEmpty(@Nullable Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            newException(message);
        }
    }

    default void notEmpty(@Nullable Collection<?> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            newException();
        }
    }

    default void state(boolean expression) {
        if (!expression) {
            newException();
        }
    }

    default void state(boolean expression, String message) {
        if (!expression) {
            newException(message);
        }
    }

    default void state(boolean expression, int code, String message) {
        if (!expression) {
            newException(code, message);
        }
    }

    default void state(boolean expression, Throwable cause) {
        if (!expression) {
            newException(cause);
        }
    }

    default void state(boolean expression, String message, Throwable cause) {
        if (!expression) {
            newException(message, cause);
        }
    }

    default void state(boolean expression, int code, String message, Throwable cause) {
        if (!expression) {
            newException(code, message, cause);
        }
    }

    default void fail() {
        state(false);
    }

    default void fail(String message) {
       state(false, message);
    }

    default void fail(int code, String message) {
        state(false, code, message);
    }

    default void fail(Throwable cause) {
        state(false, cause);
    }

    default void fail(String message, Throwable cause) {
        state(false, message, cause);
    }

    default void fail(int code, String message, Throwable cause) {
        state(false, code, message, cause);
    }

    default void newException(int code, String message) {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor(int.class, String.class).newInstance(code,message);
        } catch (InstantiationException e) {
            throw new RuntimeException(message);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(message);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(message);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(message);
        }
    }

    default void newException(String message) {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor(String.class).newInstance(message);
        } catch (InstantiationException e) {
            throw new RuntimeException(message);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(message);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(message);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(message);
        }
    }

    default void newException() {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    default void newException(Throwable cause) {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor(Throwable.class).newInstance(cause);
        } catch (InstantiationException e) {
            throw new RuntimeException(cause);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(cause);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(cause);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(cause);
        }
    }

    default void newException(String message, Throwable cause) {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor(String.class, Throwable.class ).newInstance(message, cause);
        } catch (InstantiationException e) {
            throw new RuntimeException(message, cause);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(message, cause);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(message, cause);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(message, cause);
        }
    }

    default void newException(int code, String message, Throwable cause) {
        Class<? extends Exception> clazz = getExceptionType();
        try {
            throw (RuntimeException)clazz.getDeclaredConstructor(int.class, String.class, Throwable.class ).newInstance(code, message, cause);
        } catch (InstantiationException e) {
            throw new RuntimeException(message, cause);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(message, cause);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(message, cause);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(message, cause);
        }
    }
}
