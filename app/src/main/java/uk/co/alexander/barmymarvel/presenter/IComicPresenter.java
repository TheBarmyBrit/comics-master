package uk.co.alexander.barmymarvel.presenter;

import java.util.List;


public interface IComicPresenter {
    interface IView {
        public void onStartLoading() ;
        public void onFinishedLoading() ;
        public void onShowComics(List comicList) ;
        public void showError(Throwable e) ;
    }

    interface IPresenter {
        public void bind(IView view) ;
        public void unbind() ;
        public void fetchComics();
    }
}
