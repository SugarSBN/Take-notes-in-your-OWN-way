package sceneset;

import application.ChangePassword;
import application.DeleteConfirm;
import application.FindBackPassword;
import application.FinishReview;
import application.Login;
import application.LoginSuccess;
import application.MainScene;
import application.NewABook;
import application.NewACard;
import application.Register;
import application.RegisterSuccess;
import application.Rename;
import application.Review;
import application.ViewCards;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ15ÈÕ
 * Management.sceneset.SceneSets.java
 ***********************************************************/

public class SceneSets {
	private static ChangePassword changePassword;// = new ChangePassword();
	private static DeleteConfirm deleteConfirm;// = new DeleteConfirm();
	private static FindBackPassword findBackPassword;// = new FindBackPassword();
	private static Login login;// = new Login();
	private static LoginSuccess loginSuccess;// = new LoginSuccess();
	private static MainScene mainScene;// = new MainScene();
	private static NewABook newABook;// = new NewABook();
	private static NewACard newACard;// = new NewACard();
	private static Register register;// = new Register();
	private static RegisterSuccess registerSuccess;// = new RegisterSuccess();
	private static Rename rename;
	private static ViewCards viewCards;
	private static Review review;
	private static FinishReview finishReview;
	
	public static FinishReview finishReview(){
		if (finishReview == null)	finishReview = new FinishReview();
		return finishReview;
	}
	public static Review review(){
		if (review == null)	review = new Review();
		return review;
	}
	
	public static Login login(){
		if (login == null)	login = new Login();
		return login;
	}
	public static LoginSuccess loginSuccess(){
		if (loginSuccess == null)	loginSuccess = new LoginSuccess();
		return loginSuccess;
	}
	public static ChangePassword changePassword(){
		if (changePassword == null)	changePassword = new ChangePassword();
		return changePassword;
	}
	public static DeleteConfirm deleteConfirm(){
		if (deleteConfirm == null)	deleteConfirm = new DeleteConfirm();
		return deleteConfirm;
	}
	public static FindBackPassword findBackPassword(){
		if (findBackPassword == null)	findBackPassword = new FindBackPassword();
		return findBackPassword;
	}
	public static MainScene mainScene(){
		if (mainScene == null)	mainScene = new MainScene();
		return mainScene;
	}
	public static NewABook newABook(){
		if (newABook == null)	newABook = new NewABook();
		return newABook;
	}
	public static NewACard newACard(){
		if (newACard == null)	newACard = new NewACard();
		return newACard;
	}
	public static Register register(){
		if (register == null)	register = new Register();
		return register;
	}
	public static RegisterSuccess registerSuccess(){
		if (registerSuccess == null)	registerSuccess = new RegisterSuccess();
		return registerSuccess;
	}
	public static Rename rename(){
		if (rename == null)		rename = new Rename();
		return rename;
	}
	public static ViewCards viewCards(){
		if (viewCards == null)	viewCards = new ViewCards();
		return viewCards;
	}
	public static void main(String[] args){
		login().showWindow();
	}
}
;