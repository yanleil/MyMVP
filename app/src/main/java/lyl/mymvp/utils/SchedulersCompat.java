package lyl.mymvp.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lyl on 2018-6-15.
 */

public class SchedulersCompat {
    private static final Observable.Transformer computationTransformer = new Observable.Transformer() {
        public Object call(Object var1) {
            return ((Observable)var1).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final Observable.Transformer ioTransformer = new Observable.Transformer() {
        public Object call(Object var1) {
            return ((Observable)var1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final Observable.Transformer newTransformer = new Observable.Transformer() {
        public Object call(Object var1) {
            return ((Observable)var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final Observable.Transformer trampolineTransformer = new Observable.Transformer() {
        public Object call(Object var1) {
            return ((Observable)var1).subscribeOn(Schedulers.trampoline()).observeOn(AndroidSchedulers.mainThread());
        }
    };
    private static final Observable.Transformer mainThreadTransformer = new Observable.Transformer() {
        public Object call(Object var1) {
            return ((Observable)var1).observeOn(AndroidSchedulers.mainThread());
        }
    };

    public SchedulersCompat() {
    }

    public static <T> Observable.Transformer<T, T> applyComputationSchedulers() {
        return computationTransformer;
    }

    public static <T> Observable.Transformer<T, T> applyIoSchedulers() {
        return ioTransformer;
    }

    public static <T> Observable.Transformer<T, T> applyNewSchedulers() {
        return newTransformer;
    }

    public static <T> Observable.Transformer<T, T> applyTrampolineSchedulers() {
        return trampolineTransformer;
    }

    public static <T> Observable.Transformer<T, T> observeOnMainThread() {
        return mainThreadTransformer;
    }
}
