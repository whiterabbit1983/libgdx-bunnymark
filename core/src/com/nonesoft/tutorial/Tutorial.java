package com.nonesoft.tutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import lombok.val;

public class Tutorial extends ApplicationAdapter {
    SpriteBatch batch;
    Array<Bunny> bunnies;
    OrthographicCamera camera;
    BitmapFont font;

    void addBunnies(int n) {
        for (int i = 0; i <= n; i++) {
            val touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            val b = new Bunny("wabbit_alpha.png");
            b.setPosition(new Vector2(touchPos.x, touchPos.y));
            b.setVelocity(new Vector2(MathUtils.random(-200, 200), MathUtils.random(-200, 200)));
            b.setBounds(new Vector2(1024, 768));

            bunnies.add(b);
        }
	}

    @Override
    public void create() {
        batch = new SpriteBatch();
        bunnies = new Array<>();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024, 768);
        font = new BitmapFont();
    }

    private void update(float deltaTime) {
        camera.update();
        if (Gdx.input.isTouched()) {
            addBunnies(100);
        }

        for (val b : bunnies) {
            b.update(deltaTime);
        }
    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(0, 1, 1, 1);
        batch.begin();
        for (val b : bunnies) {
            b.draw(batch);
        }
        font.draw(batch, String.format("FPS: %d", Gdx.graphics.getFramesPerSecond()), 20, 20);
        font.draw(batch, String.format("Count: %d", bunnies.size), 20, 50);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bunnies.forEach(Bunny::dispose);
    }
}
