package am1010.studio.meteor.particle.initializers;

import java.util.Random;

import am1010.studio.meteor.particle.Particle;

public interface ParticleInitializer {

	void initParticle(Particle p, Random r);

}
