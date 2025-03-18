package com.superkiment.ttd.common.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.superkiment.ttd.common.Time;
import com.superkiment.ttd.common.types.KVector;
import lombok.Data;

/**
 * Base entity class for creating entities like Dog, Player, etc.
 *
 * @author <a href="https://github/superkiment/">SuperKiment's GitHub</a>
 */
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Entity {
    /**
     * Entity's base speed, used to calculate the magnitude of the velocity vector.
     */
    public float speed = 0.3f;

    /**
     * Vectors for position, direction and direction when nothing is touched
     */
    public KVector pos, dir, remanantDir;

    /**
     * Unique identifier for this entity in the world
     */
    public String id = "";

    /**
     * List of hitboxes for this entity, passive and physics.
     */
//    public ArrayList<Hitbox> hitboxes;

    /**
     * The manager where this entity is stored.
     */
//    protected EntityManager entityManager;

    /**
     * The manager managing the entity's interactions. Used with the interface
     * InteractionManager
     */
//    protected InteractionManager interactionManager;

//    public SayingBox sayingBox;

    public Entity() {
//        String characters = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890&éèâêô@àù£";
        String characters = "abcd";
        try {
            for (int i = 0; i < 20; i++) {
                int rand = (int) Math.floor(Math.random() * characters.length());
                char ch = characters.charAt(rand);

                id += ch;
            }
        } catch (Exception e) {
            id = "failed to generate";
        }

        pos = new KVector();
        dir = new KVector();
        remanantDir = new KVector();

//        hitboxes = new ArrayList<Hitbox>();
//        hitboxes.add(new Hitbox(this, new KVector(0, 0), 20));

//        interactionManager = new InteractionManager(this);
//        sayingBox = new SayingBox(this);
    }

    /**
     * Main method for updating the entity : moving, collision.
     */
    public void Update() {
        Deplacement();
//        CheckCollision();
    }

    /**
     * Main method for moving the entity
     */
    private void Deplacement() {
        KVector dirTemp = dir.copy();
        dirTemp.setMag(speed * Time.moyenneTime);
        pos.add(dirTemp);

        if (dir.mag() != 0) {
            remanantDir.set(dir);
        }
    }

    /**
     * Main method for checking collisions
    private void CheckCollision() {

        ArrayList<Entity> allEntities = entityManager.getEntities();
        for (int i = 0; i < allEntities.size(); i++) {
            Entity entity = allEntities.get(i);

            if (entity == this)
                continue;

            for (Hitbox hitboxOther : entity.hitboxes) {
                for (Hitbox hitboxThis : this.hitboxes) {

                    // On récup les positions calculées qu'une fois
                    com.superkiment.utils.Pair<Boolean, PVector[]> pair = hitboxThis.isCollisionWith(hitboxOther);

                    // Puis on teste
                    if (pair.getFirst()) {
                        // System.out.println("COLLISION " + this.pos + " / " + entity.pos);

                        // Et on lui donne els positions calculées
                        hitboxThis.doAction(entity, hitboxOther, pair.getSecond());
                    }
                }
            }
        }
    }
     */

    /**
     * Get the entity's json information
     *
     * @return the entity's json
    public JSONObject getJSON() {
        JSONObject obj = new JSONObject();

        obj.setFloat("pos.x", pos.x);
        obj.setFloat("pos.y", pos.y);
        obj.setFloat("dir.x", remanantDir.x);
        obj.setFloat("dir.y", remanantDir.y);

        obj.setString("className", this.getClass().getName());

        obj.setString("textSaying", sayingBox.getSayingText());

        obj.setFloat("speed", speed);

        obj.setString("ID", ID);
        return obj;
    }
     */

    @JsonIgnore
    public String getClassName() {
        System.out.println("Nom : " + this.getClass().getName().split("entities.")[1]);
        String[] tabl = this.getClass().getName().split("entities.");
        return tabl[1];
    }

    /**
     * Update the entity's information from a JSON
     *
     * @param json
    public void UpdateFromJSON(JSONObject json) {
        try {
            pos.x = json.getFloat("pos.x");
            pos.y = json.getFloat("pos.y");
            remanantDir.x = json.getFloat("dir.x");
            remanantDir.y = json.getFloat("dir.y");
            speed = json.getFloat("speed");
            ID = json.getString("ID");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     */
}