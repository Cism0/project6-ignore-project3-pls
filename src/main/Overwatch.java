package main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import images.dis.imag;
import win.Window;

public class Overwatch {
	
	//Instance Variables
	private Window _w;
	private boolean _fir = false;
	private boolean _wat = false;
	private boolean _gra = false;
	private boolean _fir2 = false;
	private boolean _wat2 = false;
	private boolean _gra2 = false;
	private boolean _fircom = false;
	private boolean _watcom = false;
	private boolean _gracom = false;
	private int _wins = 0;
	private int _p2Wins = 0;
	private int _comWins = 0;
	private int _numgames = 0;
	private int _currentgamesplayed = 0;
	private int _reqVictories = 2;
	
	//Button options
	private static final String[] OPTION = { "Ya", "Nah" };
	private static final String[] PLAYERS = { "Against my Rival!", "Against Prof Oak","Im tired today" };
	private static final ImageIcon[] IMAGES = { imag.getFire(), imag.getWater(), imag.getGrass()};
	
	//This is the main method that handles the Introduction for the player and explains the rules. It asks how many rounds would like to be played and against who. 
	//It also calculates the required victories for either players or for the computer to win. Checks all possible win conditions to see who reached the required victories.
	public Overwatch() {
		_w = new Window();
		_w.msg("Welcome to your training battle Pokemon Trainer!" +
		"\nToday you will be facing off against Professor Oak, he will teach you the ropes and runs of Pokemon battles! "
		+ "Or you can face off against your rival in a battle of heart! \nRemember:" 
		+ "\nFire beats Grass! \nWater beats Fire! \nGrass beats Water!");
		int x = _w.option(PLAYERS, "Are you going to play versus the Professor Oak(CPU), or against your Rival(friend)?");
		
		if(x == 0) {
			//try {
				_numgames = Integer.parseInt(JOptionPane.showInputDialog("How many rounds would you like to play against your Rival?"));

				//}
				//catch(Exception e) {
					//JOptionPane.showMessageDialog(null, "Thats not a number! I guess you want to play three rounds then!");
					//_numgames = 3;
				//}

			_reqVictories = ((_numgames/2) + 1);
			_w.msg("You will play " + _numgames + "." + " First to " + _reqVictories + " victories, WINS!");
			
			while(_wins < _reqVictories || _p2Wins < _reqVictories) {
				if(_p2Wins == _reqVictories) {
					_w.msg("P2 Won the Match!");
					int y = _w.option(OPTION, "Care to Play again?");
					if ( y ==0) {
						_w.msg("Awesome");
						new Overwatch();
					}
					else {
						_w.msg("See ya!");
						System.exit(0);
					}
				}
				else if(_wins == _reqVictories) {
					_w.msg("P1 Won the Match!");
					int y = _w.option(OPTION, "Care to Play again?");
					if ( y ==0) {
						_w.msg("Awesome");
						new Overwatch();
					}
					else {
						_w.msg("See ya!");
						System.exit(0);
					}
				}
			checkPlayerChoice();
			checkPlayerTwosChoice();
			playerWinsVP2();
			playerLossesVP2();
			TieVP2();			
			}
			
		}
		else if(x == 1) {
			try {
				_numgames = Integer.parseInt(JOptionPane.showInputDialog("How many rounds would you like to play against Professor Oak?"));

				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Thats not a number! I guess you want to play three rounds then!");
					_numgames = 3;
				}

			_reqVictories = ((_numgames/2) + 1);
			_w.msg("You will play " + _numgames + "." + " First to " + _reqVictories + " victories, WINS!");
			
			while(_wins < _reqVictories || _comWins < _reqVictories) {
				
				if(_wins == _reqVictories) {
					_w.msg("P1 Won the Match!");
					int y = _w.option(OPTION, "Care to Play again?");
					if ( y ==0) {
						_w.msg("Awesome");
						new Overwatch();
					}
					else {
						_w.msg("See ya!");
						System.exit(0);
					}
				}
				else if(_comWins == _reqVictories) {
					_w.msg("Darn Professor Oak won");
					int y = _w.option(OPTION, "Care to Play again?");
					if ( y ==0) {
						_w.msg("Awesome");
						new Overwatch();
					}
					else {
						_w.msg("See ya!");
						System.exit(0);
					}
				}
				
				checkPlayerChoice();
				checkComChoice();
				playerWinsVCom();
				playerLossesVCom();
				TieVCom();
				}
			}
			
		else {
			_w.msg("Alright swing by tomorrow for the lesson, bye bye.");
			System.exit(0);
		}
	}
	//These methods set the instances variables 
		public void watIsTrue() {
			_wat = true;
			_fir = false;
			_gra = false;
			
		}
		public void graIsTrue() {
			_gra = true;
			_fir = false;
			_wat = false;
		}
		public void firIsTrue() {
			_fir = true;
			_wat = false;
			_gra = false;
		}
		public void wat2IsTrue() {
			_wat2 = true;
			_fir2 = false;
			_gra2 = false;
			
		}
		public void gra2IsTrue() {
			_gra2 = true;
			_fir2 = false;
			_wat2 = false;
		}
		public void fir2IsTrue() {
			_fir2 = true;
			_wat2 = false;
			_gra2 = false;
		}
		public void watComIsTrue() {
			_watcom = true;
			_fircom = false;
			_gracom = false;
		}
		public void graComIsTrue() {
			_gracom = true;
			_fircom = false;
			_watcom = false;
		}
		public void firComIsTrue() {
			_fircom = true;
			_watcom = false;
			_gracom = false;
		}
		
	//This method checks Player 1 option and sets the value
	public void checkPlayerChoice() {
		int x = _w.option(IMAGES, "Choose "+"P1 has\n " + _wins + " wins out of " + _numgames + " games to play.","BATTLE!", null);
		if( x == 0) {
			firIsTrue();
			
		}
		else if( x == 1) {
			watIsTrue();
			
		}
		else if( x == 2) {
			graIsTrue();
			
		}

		else{
			_w.msg("See ya!");
			System.exit(0);
		}
		
				
	}
	
	//This method checks Player 2 option and sets the value
	public void checkPlayerTwosChoice() {
		int x = _w.option(IMAGES, "Choose P2" + " P2 has "+ _p2Wins + " wins out of " + _numgames+ " games to play.","BATTLE!", null);
		if( x == 0) {
			fir2IsTrue();
			
		}
		else if( x == 1) {
			wat2IsTrue();
			
		}
		else if( x == 2) {
			gra2IsTrue();
			
		}
		else {
			_w.msg("See ya!");
			System.exit(0);
		}
		
				
	}
	
	//This method checks Computer's option and sets the value
	public void checkComChoice() {
		int x = (int)(Math.random() * 3);
		if( x == 0) {
			firComIsTrue();
			
			_w.msg("Professor Oak chose Fire!");
		}
		else if( x == 1) {
			watComIsTrue();
			
			_w.msg("Professor Oak chose Water!");
		}
		else if( x == 2) {
			graComIsTrue();
		
			_w.msg("Professor Oak chose Grass!");
		}
			
	}
	
	//This method checks if the player beats the Computers choice
	public void playerWinsVCom() {
		if(_fir == true && _gracom == true) { //IF player choose fire and computer choose grass
			_wins++;
			
			_w.msg("P1 Wins");
		}
		else if(_wat == true && _fircom == true) {//IF player choose water and computer choose fire
			_wins++;
			
			_w.msg("P1 Wins");
		}
		else if(_gra == true && _watcom == true) {//IF player choose grass and computer choose water
			_wins++;
			
			_w.msg("P1 Wins");
		}	
	}
	
	//This method checks if the player losses to the Computers choice
	public void playerLossesVCom() {
		if(_fir == true && _watcom == true) { //IF player choose fire and computer choose water
			
			_comWins++;
			_w.msg("P1 Losses");
		}
		else if(_wat == true && _gracom == true) {//IF player choose water and computer choose grass
			
			_comWins++;
			_w.msg("P1 Losses");
		}
		else if(_gra == true && _fircom == true) {//IF player choose grass and computer choose fire
			
			_comWins++;
			_w.msg("P1 Losses");
		}	
	}

	//This method checks if player 1 beats the player 2 choice
	public void playerWinsVP2() {
		if (_fir == true && _gra2 == true) { // IF player choose fire and P2 choose grass
			_wins++;
			
			_w.msg("P1 Wins!");
		} else if (_wat == true && _fir2 == true) {// IF player choose water and P2 choose fire
			_wins++;
			
			_w.msg("P1 Wins!");
		} else if (_gra == true && _wat2 == true) {// IF player choose grass and P2 choose water
			_wins++;
			
			_w.msg("P1 Wins!");
		}
	}
	
	//This method checks if player 1 losses to the player 2 choice
	public void playerLossesVP2() {
		
		if(_fir == true && _wat2 == true) { //IF player choose fire and P2 choose water
			
			_p2Wins++;
			_w.msg("You Won P2");
		}
		else if(_wat == true && _gra2 == true) {//IF player choose water and P2 choose grass
			
			_p2Wins++;
			_w.msg("You Won P2");
		}
		else if(_gra == true && _fir2 == true) {//IF player choose grass and P2 choose fire
			
			_p2Wins++;
			_w.msg("You Won P2");
		}	
	}
	
	//This method checks if player 1 ties the Computer choice
	public void TieVCom() {
		
		if(_fir == true && _fircom == true) { //IF player choose fire and computer choose fire
			
			_w.msg("You Tied");
		}
		else if(_wat == true && _watcom == true) {//IF player choose water and computer choose water
			
			_w.msg("You Tied");
		}
		else if(_gra == true && _gracom == true) {//IF player choose grass and computer choose grass
			
			_w.msg("You Tied");
		}	
	}
	
	//This method checks if player 1 ties the player 2 choice
	public void TieVP2() {
		
		if(_fir == true && _fir2 == true) { //IF player choose fire and P2 choose fire
			
			_w.msg("You Guys Tied");
		}
		else if(_wat == true && _wat2 == true) {//IF player choose water and P2 choose water
			
			_w.msg("You Guys Tied");
		}
		else if(_gra == true && _gra2 == true) {//IF player choose grass and P2 choose grass
			
			_w.msg("You Guys Tied");
		}	
	}

	
	
}
