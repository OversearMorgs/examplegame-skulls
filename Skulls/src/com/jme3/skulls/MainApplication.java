package com.jme3.skulls;

import com.bruynhuis.galago.app.Base3DApplication;
import static com.bruynhuis.galago.app.BaseApplication.BACKGROUND_COLOR;
import com.bruynhuis.galago.resource.EffectManager;
import com.bruynhuis.galago.resource.ModelManager;
import com.bruynhuis.galago.resource.ScreenManager;
import com.bruynhuis.galago.resource.SoundManager;
import com.bruynhuis.galago.resource.TextureManager;
import com.jme3.skulls.screens.EditScreen;
import com.jme3.skulls.screens.MenuScreen;
import com.jme3.skulls.screens.PlayScreen;
import com.jme3.skulls.screens.SettingsScreen;
import com.jme3.math.ColorRGBA;

/**
 * This is the main application class which will be excecuted when application
 * starts.
 *
 * @author Nicolaas de Bruyn
 */
public class MainApplication extends Base3DApplication {

    /**
     * This is the default constructor and must be called from the main()
     * method.
     */
    public MainApplication() {
        //This constructor is used to initialize app specific things
        //Title, native width, native height, gameSaveDataFile, font if not default, splash if needed, enablephysics, enable size selection
        super("Skulls", 1280, 720, "skulls.save", null, null, true);
    }

    public static void main(String[] args) {
        new MainApplication();
    }

    @Override
    protected void preInitApp() {
        
        //This method is called before any screen or game data is loaded
        BACKGROUND_COLOR = ColorRGBA.Black;
        splashInfoMessage = "jMonkeyEngine3 Example Game";

    }

    @Override
    protected void postInitApp() {
        //This method is called after all screens and game data is loaded
        showScreen("menu");

    }

    @Override
    protected void initScreens(ScreenManager screenManager) {
        //This method will be called to load screen states defined
        screenManager.loadScreen("menu", new MenuScreen());
        screenManager.loadScreen("settings", new SettingsScreen());
        screenManager.loadScreen("play", new PlayScreen());
        screenManager.loadScreen("edit", new EditScreen());

    }

    @Override
    protected void initSound(SoundManager soundManager) {
        //Here we will preload sounds and music we wish to use in the game
        soundManager.loadSoundFx("mate", "Sounds/mate.ogg");
        soundManager.setSoundVolume("mate", 0.1f);

        soundManager.loadSoundFx("death", "Sounds/death.ogg");
        soundManager.setSoundVolume("death", 0.6f);

        soundManager.loadSoundFx("button", "Sounds/button.ogg");
        soundManager.setSoundVolume("button", 0.5f);
        
        soundManager.loadMusic("menu", "Sounds/menu.ogg");
        soundManager.setMusicVolume("menu", 0.5f);

        soundManager.loadMusic("level", "Sounds/level.ogg");
        soundManager.setMusicVolume("level", 0.5f);

    }

    @Override
    protected void initEffect(EffectManager effectManager) {
        //Here we preload particle effects that we wish to execute at runtime
        effectManager.loadEffect("love", "Models/effects/love.j3o");
        effectManager.loadEffect("die", "Models/effects/dust.j3o");
        effectManager.loadEffect("bomb", "Models/effects/explosion/explosion.j3o");

    }

    @Override
    public void initModelManager(ModelManager modelManager) {
        //Here we preload models and materials that might be shared between levels.
        //It is not needed one can still call the assetmanager to load models.

        modelManager.loadMaterial("Models/enemies/skeleton/skeleton.j3m");
        modelManager.loadMaterial("Materials/tile-blank.j3m");
        modelManager.loadMaterial("Materials/tile-enemy.j3m");

        modelManager.loadModel("Models/enemies/ghost/ghost.j3o");
        modelManager.loadModel("Models/enemies/mummy/mummy.j3o");
        modelManager.loadModel("Models/enemies/skeleton/skeleton.j3o");
        modelManager.loadModel("Models/enemies/zombie/zombie.j3o");
        modelManager.loadModel("Models/enemies/shadow.j3o");

        modelManager.loadModel("Models/powers/poison.j3o");
        modelManager.loadModel("Models/powers/male.j3o");
        modelManager.loadModel("Models/powers/female.j3o");
        modelManager.loadModel("Models/powers/stop.j3o");
        modelManager.loadModel("Models/powers/bomb.j3o");
        modelManager.loadModel("Models/powers/sterilize.j3o");
        modelManager.loadModel("Models/powers/gas.j3o");

        modelManager.loadModel("Models/static/dungeon.j3o");
        modelManager.loadMaterial("Models/static/dungeon.j3m");



    }

    /**
     * Helper method which returns an instance of the play screen
     *
     * @return
     */
    public PlayScreen getPlayScreen() {
        return (PlayScreen) screenManager.getScreen("play");
    }

    @Override
    protected void initTextures(TextureManager textureManager) {
        textureManager.loadTexture("Interface/popup.png");
    }

    @Override
    protected boolean isPhysicsEnabled() {
        return false;
    }
}
