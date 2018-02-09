package com.technologyleaks.retailistanchat.register;

/**
 * Created by Shahzore on 08-Feb-18.
 */


import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Holder interface that contains all interfaces
 * responsible to maintain communication between
 * Model View Presenter layers.
 * Each layer implements its respective interface:
 * View implements RequiredViewOps
 * Presenter implements ProvidedPresenterOps, RequiredPresenterOps
 * Model implements ProvidedModelOps
 */
public interface MVP_Register {
    /**
     * Required View methods available to Presenter.
     * A passive layer, responsible to show data
     * and receive user interactions
     * Presenter to View
     */
    interface PresenterToView {
        Context getAppContext();

        Context getActivityContext();

        void showToast(Toast toast);

        void showProgress();

        void hideProgress();


    }

    /**
     * Operations offered to View to communicate with Presenter.
     * Process user interaction, sends data requests to Model, etc.
     * View to Presenter
     */
    interface ViewToPresenter {
        void onDestroy(boolean isChangingConfiguration);

        void setView(PresenterToView view);

        void onRegisterButtonClicked(EditText editText_username, EditText editText_type_password, EditText editText_re_type_password, Button button_login);


    }

    /**
     * Required Presenter methods available to Model.
     * Model to Presenter
     */
    interface ModelToPresenter {

        Context getAppContext();

        Context getActivityContext();

        void onRegisterError(String errorMessage);

        void onRegisterSuccess(String userId, String userName);

        void onResponse();


    }

    /**
     * Operations offered to Model to communicate with Presenter
     * Handles all data business logic.
     * Presenter to Model
     */
    interface PresenterToModel {

        void onDestroy(boolean isChangingConfiguration);

        void saveRegisterData(String userName, String password);


    }
}
