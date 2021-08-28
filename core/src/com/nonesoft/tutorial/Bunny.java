package com.nonesoft.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Bunny {
    @Setter
    private Vector2 position;
    @Setter
    private Vector2 velocity;
    @Setter
    private Vector2 bounds;
    private final Texture img;

    Bunny(String fileName) {
        img = new Texture(Gdx.files.internal(fileName));
        position = Vector2.Zero;
        velocity = Vector2.Zero;
        bounds = Vector2.Zero;
    }

    public void update(float deltaTime) {
        position.mulAdd(velocity, deltaTime);

        if (position.x <= 0 || position.x >= bounds.x) velocity.x = -velocity.x;
        if (position.y <= 0 || position.x >= bounds.y) velocity.y = -velocity.y;
    }

    public void draw(@NotNull SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

    public void dispose() {
        img.dispose();
    }
}
