package com.nonesoft.tutorial;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameEntity {
    void update(float deltaTime);
    void draw(SpriteBatch batch);
    void dispose();
}
