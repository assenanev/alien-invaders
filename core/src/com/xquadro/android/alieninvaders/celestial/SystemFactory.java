package com.xquadro.android.alieninvaders.celestial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xquadro.android.alieninvaders.levels.Level.LevelName;
import com.xquadro.android.alieninvaders.world.World;

public class SystemFactory {

	public static List<CelestialBody> buildSystem(LevelName levelName) {
		List<CelestialBody> system = new ArrayList<CelestialBody>();
		return system;
	}

	
	public static Star fillSystem(LevelName levelName, List<CelestialBody> system, Random rand){
		Star star;
		
		switch (levelName) {
		case SUN:
			star = fillSystemSun(system, rand);
			break;
		case BETA_CENTAURI:
			star = fillSystemBeta_Centauri(system, rand);
			break;
		case PROCYON:
			star = fillSystemProcyon(system, rand);
			break;
		case ALTAIR:
			star = fillSystemAltair(system, rand);
			break;
		case ELNATH:
			star = fillSystemElnath(system, rand);
			break;
		case NAOS:
			star = fillSystemNaos(system, rand);
			break;
		case ALCHIBA:
			star = fillSystemAlchiba(system, rand);
			break;
		case SYRMA:
			star = fillSystemSyrma(system, rand);
			break;
		case TARAZED:
			star = fillSystemTarazed(system, rand);
			break;
		case ALKALUROPS:
			star = fillSystemAlkalurops(system, rand);
			break;
		case AVIOR:
			star = fillSystemAvior(system, rand);
			break;
		case MIRA:
			star = fillSystemMira(system, rand);
			break;
		case CAPELLA:
			star = fillSystemCapella(system, rand);
			break;
		case REGEL:
			star = fillSystemRegel(system, rand);
			break;
		case ACHERNAR:
			star = fillSystemAchernar(system, rand);
			break;
		case ALDEBARAN:
			star = fillSystemAldebaran(system, rand);
			break;
		case FOMALHAUT:
			star = fillSystemFomalhaut(system, rand);
			break;
		case ALPHA_CRUCIS:
			star = fillSystemAlpha_Crucis(system, rand);
			break;
		case BETA_CRUCIS:
			star = fillSystemBeta_Crucis(system, rand);
			break;
		case GRAFIAS:
			star = fillSystemGrafias(system, rand);
			break;
		case MARFAK:
			star = fillSystemMarfak(system, rand);
			break;
		case SEGIN:
			star = fillSystemSegin(system, rand);
			break;
		case CANOPUS:
			star = fillSystemCanopus(system, rand);
			break;
		case THABIT:
			star = fillSystemThabit(system, rand);
			break;
		case TEGMINE:
			star = fillSystemTegmine(system, rand);
			break;
		case SIRIUS:
			star = fillSystemSirius(system, rand);
			break;
		case ALPHA_CENTAURI:
			star = fillSystemAlpha_Centauri(system, rand);
			break;
		case VEGA:
			star = fillSystemVega(system, rand);
			break;
		case ADHAFERA:
			star = fillSystemAdhafera(system, rand);
			break;
		case BETELGEUSE:
			star = fillSystemBetelgeuse(system, rand);
			break;
		case SPICA:
			star = fillSystemSpica(system, rand);
			break;
		case ANTARES:
			star = fillSystemAntares(system, rand);
			break;
		case POLLUX:
			star = fillSystemPollux(system, rand);
			break;
		case DENEB:
			star = fillSystemDeneb(system, rand);
			break;
		case ALRAI:
			star = fillSystemAlrai(system, rand);
			break;
		case TURAIS:
			star = fillSystemTurais(system, rand);
			break;
		case ARCTURUS:
			star = fillSystemArcturus(system, rand);
			break;
		case BELLATRIX:
			star = fillSystemBellatrix(system, rand);
			break;
		case CASTOR:
			star = fillSystemCastor(system, rand);
			break;
		case ELECTRA:
			star = fillSystemElectra(system, rand);
			break;
		case KEID:
			star = fillSystemKeid(system, rand);
			break;
		case SHARATAN:
			star = fillSystemSharatan(system, rand);
			break;
		case REGULUS:
			star = fillSystemRegulus(system, rand);
			break;
		case MIMOSA:
			star = fillSystemMimosa(system, rand);
			break;
		case WEZEN:
			star = fillSystemWezen(system, rand);
			break;
		case PISCES:
			star = fillSystemPisces(system, rand);
			break;
		case ARIES:
			star = fillSystemAries(system, rand);
			break;
		case FURUD:
			star = fillSystemFurud(system, rand);
			break;
		case NUSAKAN:
			star = fillSystemNusakan(system, rand);
			break;
		case MINKAR:
		default:
			star = fillSystemMinkar(system, rand);
			break;
		}
		
		return star;
	}

	// SUN
	public static Star fillSystemSun(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet0 = new Planet(6.938341f, 360 * rand.nextFloat(),
				1.1661179f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet0);
		Planet planet1 = new Planet(9.9628525f, 360 * rand.nextFloat(),
				1.3825011f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet1);
		Planet planet5 = new Planet(30.050777f, 360 * rand.nextFloat(),
				1.3356243f, CelestialBody.Celestial.PLANET_EARTH, star, false);
		system.add(planet5);
		Planet satelite50 = new Planet(2.110817f, 360 * rand.nextFloat(),
				0.60541725f, CelestialBody.Celestial.PLANET_MOON_0, planet5, true);
		satelite50.sateliteRotationSpeed = 30.132927f;
		system.add(satelite50);
		Planet planet6 = new Planet(40.050777f, 360 * rand.nextFloat(),
				1.0356243f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet6);
		Planet satelite60 = new Planet(2.110817f, 360 * rand.nextFloat(),
				0.60541725f, CelestialBody.Celestial.PLANET_FOBOS, planet6, false);
		satelite60.sateliteRotationSpeed = 40.132927f;
		system.add(satelite60);
		Planet planet8 = new Planet(54.0848f, 360 * rand.nextFloat(),
				3.110817f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet8);
		
		Planet satelite80 = new Planet(2.110817f, 360 * rand.nextFloat(),
				0.60541725f, CelestialBody.Celestial.PLANET_GANYMEDE, planet8, true);
		satelite80.sateliteRotationSpeed = 30.132927f;
		system.add(satelite80);
		Planet planet9 = new Planet(60.0848f, 360 * rand.nextFloat(),
				3.110817f, CelestialBody.Celestial.PLANET_TRITON, star, false);
		system.add(planet9);
		
		Planet planet10 = new Planet(65.844759f, 360 * rand.nextFloat(),
				2.7552147f, CelestialBody.Celestial.PLANET_CALISTO_GREEN, star, true);
		system.add(planet10);
		
		return star;
	}

	// BETA_CENTAURI
	public static Star fillSystemBeta_Centauri(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet2 = new Planet(18.622131f, 360 * rand.nextFloat(),
				1.0213532f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet2);
		Planet planet5 = new Planet(30.050777f, 360 * rand.nextFloat(),
				1.3356243f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet5);
		Planet planet8 = new Planet(54.0848f, 360 * rand.nextFloat(),
				2.110817f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet8);
		Planet satelite80 = new Planet(2.110817f, 360 * rand.nextFloat(),
				0.60541725f, CelestialBody.Celestial.PLANET_GANYMEDE, planet8, true);
		satelite80.sateliteRotationSpeed = 30.132927f;
		system.add(satelite80);
		return star;
	}

	// PROCYON
	public static Star fillSystemProcyon(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet1 = new Planet(11.140284f, 360 * rand.nextFloat(),
				2.741692f, CelestialBody.Celestial.PLANET_JUPITER_1, star, false);
		system.add(planet1);
		Planet planet2 = new Planet(16.074825f, 360 * rand.nextFloat(),
				2.5127025f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet2);
		Planet satelite21 = new Planet(3.0132809f, 360 * rand.nextFloat(),
				0.83699566f, CelestialBody.Celestial.PLANET_CALISTO_1, planet2, true);
		satelite21.sateliteRotationSpeed = 33.69729f;
		system.add(satelite21);
		Planet planet5 = new Planet(30.03947f, 360 * rand.nextFloat(),
				2.879281f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet5);
		Planet satelite50 = new Planet(2.879281f, 360 * rand.nextFloat(),
				1.079622f, CelestialBody.Celestial.PLANET_MOON_0, planet5, true);
		satelite50.sateliteRotationSpeed = 28.652607f;
		system.add(satelite50);
		Planet planet6 = new Planet(42.82524f, 360 * rand.nextFloat(),
				1.8309911f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet6);
		Planet planet8 = new Planet(53.839115f, 360 * rand.nextFloat(),
				2.5509949f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet8);
		Planet satelite82 = new Planet(2.6317549f, 360 * rand.nextFloat(),
				1.2593286f, CelestialBody.Celestial.PLANET_CALISTO_1, planet8, true);
		satelite82.sateliteRotationSpeed = -31.082127f;
		system.add(satelite82);
		return star;
	}

	// ALTAIR
	public static Star fillSystemAltair(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(4.440483f, 360 * rand.nextFloat(),
				1.0075666f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet0);
		Planet planet1 = new Planet(11.029157f, 360 * rand.nextFloat(),
				1.3279996f, CelestialBody.Celestial.PLANET_2, star, false);
		system.add(planet1);
		Planet planet2 = new Planet(15.664775f, 360 * rand.nextFloat(),
				2.0117373f, CelestialBody.Celestial.PLANET_GANYMEDE, star, false);
		system.add(planet2);
		Planet planet4 = new Planet(30.561213f, 360 * rand.nextFloat(),
				2.4049244f, CelestialBody.Celestial.PLANET_TRITON, star, false);
		system.add(planet4);
		Planet planet9 = new Planet(62.367268f, 360 * rand.nextFloat(),
				1.2610333f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet9);
		return star;
	}

	// ELNATH
	public static Star fillSystemElnath(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet0 = new Planet(3.7045465f, 360 * rand.nextFloat(),
				1.5694349f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet0);
		Planet planet1 = new Planet(11.1199255f, 360 * rand.nextFloat(),
				2.8448133f, CelestialBody.Celestial.PLANET_3, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(16.81041f, 360 * rand.nextFloat(),
				2.5724053f, CelestialBody.Celestial.PLANET_JUPITER_0, star, false);
		system.add(planet2);
		Planet planet6 = new Planet(40.511307f, 360 * rand.nextFloat(),
				1.9077821f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet6);
		Planet planet9 = new Planet(60.074093f, 360 * rand.nextFloat(),
				1.9616021f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet9);
		return star;
	}

	// NAOS
	public static Star fillSystemNaos(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet0 = new Planet(6.1659946f, 360 * rand.nextFloat(),
				2.6433983f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet0);
		Planet planet3 = new Planet(23.444836f, 360 * rand.nextFloat(),
				2.4499407f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet3);
		Planet planet5 = new Planet(40.7428f, 360 * rand.nextFloat(),
				2.7944767f, CelestialBody.Celestial.PLANET_JUPITER_1, star, true);
		system.add(planet5);
		Planet satelite50 = new Planet(2.7944767f, 360 * rand.nextFloat(),
				0.90037274f, CelestialBody.Celestial.PLANET_MIMAS, planet5, false);
		satelite50.sateliteRotationSpeed = -34.828465f;
		system.add(satelite50);
		Planet satelite51 = new Planet(3.2598526f, 360 * rand.nextFloat(),
				1.4569271f, CelestialBody.Celestial.PLANET_1, planet5, true);
		satelite51.sateliteRotationSpeed = -34.65515f;
		system.add(satelite51);
		Planet planet7 = new Planet(47.009613f, 360 * rand.nextFloat(),
				2.9826508f, CelestialBody.Celestial.PLANET_4, star, false);
		system.add(planet7);
		Planet planet9 = new Planet(60.583927f, 360 * rand.nextFloat(),
				2.2097254f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet9);
		return star;
	}

	// ALCHIBA
	public static Star fillSystemAlchiba(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet1 = new Planet(11.400486f, 360 * rand.nextFloat(),
				2.1420944f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet1);
		Planet satelite12 = new Planet(3.0305285f, 360 * rand.nextFloat(),
				0.6350197f, CelestialBody.Celestial.PLANET_CALISTO_0, planet1, true);
		satelite12.sateliteRotationSpeed = -24.177727f;
		system.add(satelite12);
		Planet planet2 = new Planet(18.119204f, 360 * rand.nextFloat(),
				2.499537f, CelestialBody.Celestial.PLANET_2, star, false);
		system.add(planet2);
		Planet planet3 = new Planet(24.363333f, 360 * rand.nextFloat(),
				2.7641363f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet3);
		Planet planet4 = new Planet(29.828093f, 360 * rand.nextFloat(),
				1.3388087f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.35941f, 360 * rand.nextFloat(),
				2.140868f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet5);
		Planet satelite52 = new Planet(3.7572153f, 360 * rand.nextFloat(),
				0.57357806f, CelestialBody.Celestial.PLANET_TRITON, planet5, false);
		satelite52.sateliteRotationSpeed = 48.282444f;
		system.add(satelite52);
		Planet planet7 = new Planet(48.14596f, 360 * rand.nextFloat(),
				1.3405141f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet7);
		Planet satelite70 = new Planet(1.3405141f, 360 * rand.nextFloat(),
				0.67025703f, CelestialBody.Celestial.PLANET_0, planet7, true);
		satelite70.sateliteRotationSpeed = -37.071587f;
		system.add(satelite70);
		Planet satelite71 = new Planet(1.9828646f, 360 * rand.nextFloat(),
				0.67025703f, CelestialBody.Celestial.PLANET_2, planet7, true);
		satelite71.sateliteRotationSpeed = 31.100393f;
		system.add(satelite71);
		Planet planet8 = new Planet(55.04319f, 360 * rand.nextFloat(),
				2.0722857f, CelestialBody.Celestial.PLANET_CALISTO_1, star, false);
		system.add(planet8);
		Planet satelite82 = new Planet(2.3284488f, 360 * rand.nextFloat(),
				0.7750416f, CelestialBody.Celestial.PLANET_EARTH_GREEN, planet8, true);
		satelite82.sateliteRotationSpeed = 28.0575f;
		system.add(satelite82);
		Planet planet9 = new Planet(59.77472f, 360 * rand.nextFloat(),
				2.495184f, CelestialBody.Celestial.PLANET_JUPITER_1, star, false);
		system.add(planet9);
		Planet satelite91 = new Planet(3.1548586f, 360 * rand.nextFloat(),
				1.0747828f, CelestialBody.Celestial.PLANET_CALISTO_1, planet9, true);
		satelite91.sateliteRotationSpeed = -46.71402f;
		system.add(satelite91);
		return star;
	}

	// SYRMA
	public static Star fillSystemSyrma(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(3.3884194f, 360 * rand.nextFloat(),
				1.2087433f, CelestialBody.Celestial.PLANET_4, star, true);
		system.add(planet0);
		Planet planet4 = new Planet(28.220726f, 360 * rand.nextFloat(),
				1.6551479f, CelestialBody.Celestial.PLANET_2, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.093513f, 360 * rand.nextFloat(),
				2.7448342f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet5);
		Planet planet9 = new Planet(62.106808f, 360 * rand.nextFloat(),
				2.7039733f, CelestialBody.Celestial.PLANET_7, star, false);
		system.add(planet9);
		Planet satelite90 = new Planet(2.7039733f, 360 * rand.nextFloat(),
				0.9609808f, CelestialBody.Celestial.PLANET_GANYMEDE, planet9, true);
		satelite90.sateliteRotationSpeed = -23.796204f;
		system.add(satelite90);
		return star;
	}

	// TARAZED
	public static Star fillSystemTarazed(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet2 = new Planet(16.590473f, 360 * rand.nextFloat(),
				2.8104954f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet2);
		Planet satelite21 = new Planet(2.8950756f, 360 * rand.nextFloat(),
				1.4631324f, CelestialBody.Celestial.PLANET_GANYMEDE, planet2, false);
		satelite21.sateliteRotationSpeed = 40.43711f;
		system.add(satelite21);
		Planet planet3 = new Planet(24.28725f, 360 * rand.nextFloat(),
				1.2088742f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet3);
		Planet satelite31 = new Planet(1.816977f, 360 * rand.nextFloat(),
				0.5563215f, CelestialBody.Celestial.PLANET_JUPITER_2, planet3, true);
		satelite31.sateliteRotationSpeed = 40.01183f;
		system.add(satelite31);
		Planet planet6 = new Planet(41.84501f, 360 * rand.nextFloat(),
				2.3150878f, CelestialBody.Celestial.PLANET_JUPITER_0, star, false);
		system.add(planet6);
		Planet planet8 = new Planet(55.827873f, 360 * rand.nextFloat(),
				2.7092953f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet8);
		Planet satelite81 = new Planet(3.3567164f, 360 * rand.nextFloat(),
				0.6757594f, CelestialBody.Celestial.PLANET_JUPITER_1, planet8, true);
		satelite81.sateliteRotationSpeed = 37.353218f;
		system.add(satelite81);
		return star;
	}

	// ALKALUROPS
	public static Star fillSystemAlkalurops(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(3.9953504f, 360 * rand.nextFloat(),
				1.2751235f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet0);
		Planet planet1 = new Planet(9.413893f, 360 * rand.nextFloat(),
				1.1390805f, CelestialBody.Celestial.PLANET_GANYMEDE, star, false);
		system.add(planet1);
		Planet planet2 = new Planet(18.12577f, 360 * rand.nextFloat(),
				2.629799f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet2);
		Planet planet3 = new Planet(25.146587f, 360 * rand.nextFloat(),
				1.234664f, CelestialBody.Celestial.PLANET_7, star, false);
		system.add(planet3);
		Planet planet5 = new Planet(40.176888f, 360 * rand.nextFloat(),
				1.9902502f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet5);
		Planet satelite51 = new Planet(2.0488114f, 360 * rand.nextFloat(),
				0.619142f, CelestialBody.Celestial.PLANET_MOON_0, planet5, false);
		satelite51.sateliteRotationSpeed = 29.534424f;
		system.add(satelite51);
		Planet planet7 = new Planet(48.66612f, 360 * rand.nextFloat(),
				1.8974352f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet7);
		return star;
	}

	// AVIOR
	public static Star fillSystemAvior(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet2 = new Planet(19.300255f, 360 * rand.nextFloat(),
				2.7453184f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet2);
		Planet satelite22 = new Planet(4.26601f, 360 * rand.nextFloat(),
				1.1896327f, CelestialBody.Celestial.PLANET_IO, planet2, false);
		satelite22.sateliteRotationSpeed = -25.232449f;
		system.add(satelite22);
		Planet planet3 = new Planet(22.84813f, 360 * rand.nextFloat(),
				2.8421714f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet3);
		Planet planet4 = new Planet(29.237114f, 360 * rand.nextFloat(),
				2.1327846f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.722595f, 360 * rand.nextFloat(),
				2.0347629f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet5);
		return star;
	}

	// MIRA
	public static Star fillSystemMira(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet1 = new Planet(12.374337f, 360 * rand.nextFloat(),
				2.6489816f, CelestialBody.Celestial.PLANET_JUPITER_1, star, false);
		system.add(planet1);
		Planet planet2 = new Planet(18.257605f, 360 * rand.nextFloat(),
				2.8611522f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet2);
		Planet planet3 = new Planet(22.290098f, 360 * rand.nextFloat(),
				1.1164505f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet3);
		Planet satelite32 = new Planet(2.6082118f, 360 * rand.nextFloat(),
				0.5582253f, CelestialBody.Celestial.PLANET_EARTH_GREEN, planet3, true);
		satelite32.sateliteRotationSpeed = -46.07704f;
		system.add(satelite32);
		Planet planet4 = new Planet(28.755795f, 360 * rand.nextFloat(),
				2.4057565f, CelestialBody.Celestial.PLANET_JUPITER_0, star, false);
		system.add(planet4);
		Planet satelite41 = new Planet(2.749859f, 360 * rand.nextFloat(),
				0.8818964f, CelestialBody.Celestial.PLANET_MOON_0, planet4, false);
		satelite41.sateliteRotationSpeed = -23.68392f;
		system.add(satelite41);
		Planet planet6 = new Planet(42.70633f, 360 * rand.nextFloat(),
				1.6336706f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet6);
		Planet planet7 = new Planet(47.377148f, 360 * rand.nextFloat(),
				2.6987753f, CelestialBody.Celestial.PLANET_MIRANDA, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(56.91619f, 360 * rand.nextFloat(),
				1.6059012f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(62.936565f, 360 * rand.nextFloat(),
				1.1145173f, CelestialBody.Celestial.PLANET_MIMAS, star, true);
		system.add(planet9);
		return star;
	}

	// CAPELLA
	public static Star fillSystemCapella(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet3 = new Planet(23.741251f, 360 * rand.nextFloat(),
				2.0758605f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet3);
		Planet satelite30 = new Planet(2.0758605f, 360 * rand.nextFloat(),
				1.2002072f, CelestialBody.Celestial.PLANET_FOBOS, planet3, false);
		satelite30.sateliteRotationSpeed = -46.032623f;
		system.add(satelite30);
		Planet planet4 = new Planet(28.824554f, 360 * rand.nextFloat(),
				2.5449739f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet4);
		Planet satelite40 = new Planet(2.5449739f, 360 * rand.nextFloat(),
				1.2255274f, CelestialBody.Celestial.PLANET_FOBOS, planet4, false);
		satelite40.sateliteRotationSpeed = -37.34352f;
		system.add(satelite40);
		Planet satelite42 = new Planet(3.2999134f, 360 * rand.nextFloat(),
				1.0174611f, CelestialBody.Celestial.PLANET_3, planet4, true);
		satelite42.sateliteRotationSpeed = -31.001362f;
		system.add(satelite42);
		Planet planet6 = new Planet(43.6267f, 360 * rand.nextFloat(),
				2.3656635f, CelestialBody.Celestial.PLANET_GANYMEDE, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(48.16258f, 360 * rand.nextFloat(),
				1.3742651f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(54.56994f, 360 * rand.nextFloat(),
				1.9080915f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet8);
		Planet satelite80 = new Planet(1.9080915f, 360 * rand.nextFloat(),
				0.93593055f, CelestialBody.Celestial.PLANET_2, planet8, false);
		satelite80.sateliteRotationSpeed = 33.996067f;
		system.add(satelite80);
		return star;
	}

	// REGEL
	public static Star fillSystemRegel(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet0 = new Planet(3.7825272f, 360 * rand.nextFloat(),
				1.7110023f, CelestialBody.Celestial.PLANET_CALISTO_GREEN, star, true);
		system.add(planet0);
		Planet planet1 = new Planet(12.969973f, 360 * rand.nextFloat(),
				1.9308778f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet1);
		Planet satelite10 = new Planet(1.9308778f, 360 * rand.nextFloat(),
				1.0935059f, CelestialBody.Celestial.PLANET_2, planet1, false);
		satelite10.sateliteRotationSpeed = -27.465517f;
		system.add(satelite10);
		Planet planet2 = new Planet(17.083942f, 360 * rand.nextFloat(),
				2.3831623f, CelestialBody.Celestial.PLANET_GANYMEDE, star, false);
		system.add(planet2);
		Planet planet3 = new Planet(22.68035f, 360 * rand.nextFloat(),
				1.2372313f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet3);
		Planet planet6 = new Planet(44.464035f, 360 * rand.nextFloat(),
				1.0276302f, CelestialBody.Celestial.PLANET_MOON_0, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(50.107414f, 360 * rand.nextFloat(),
				2.3953469f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(54.228462f, 360 * rand.nextFloat(),
				2.3086326f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(62.434853f, 360 * rand.nextFloat(),
				1.7578763f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet9);
		return star;
	}

	// ACHERNAR
	public static Star fillSystemAchernar(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet2 = new Planet(17.135124f, 360 * rand.nextFloat(),
				2.1937485f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet2);
		Planet planet4 = new Planet(28.843267f, 360 * rand.nextFloat(),
				2.4241054f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.87088f, 360 * rand.nextFloat(),
				1.9220678f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet5);
		Planet satelite50 = new Planet(1.9220678f, 360 * rand.nextFloat(),
				1.0039562f, CelestialBody.Celestial.PLANET_2, planet5, false);
		satelite50.sateliteRotationSpeed = -25.328716f;
		system.add(satelite50);
		Planet planet9 = new Planet(62.593773f, 360 * rand.nextFloat(),
				1.826524f, CelestialBody.Celestial.PLANET_3, star, true);
		system.add(planet9);
		Planet satelite90 = new Planet(1.826524f, 360 * rand.nextFloat(),
				0.7473483f, CelestialBody.Celestial.PLANET_JUPITER_2, planet9, true);
		satelite90.sateliteRotationSpeed = -40.392105f;
		system.add(satelite90);
		Planet satelite92 = new Planet(3.7578115f, 360 * rand.nextFloat(),
				1.2918715f, CelestialBody.Celestial.PLANET_3, planet9, false);
		satelite92.sateliteRotationSpeed = -29.838955f;
		system.add(satelite92);
		return star;
	}

	// ALDEBARAN
	public static Star fillSystemAldebaran(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet0 = new Planet(5.4544945f, 360 * rand.nextFloat(),
				1.5317769f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet0);
		Planet satelite00 = new Planet(1.5317769f, 360 * rand.nextFloat(),
				0.66297036f, CelestialBody.Celestial.PLANET_CALISTO_0, planet0, false);
		satelite00.sateliteRotationSpeed = -20.713432f;
		system.add(satelite00);
		Planet planet3 = new Planet(24.938297f, 360 * rand.nextFloat(),
				1.6720573f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet3);
		Planet planet5 = new Planet(30.955055f, 360 * rand.nextFloat(),
				2.5202804f, CelestialBody.Celestial.PLANET_CALISTO_GREEN, star, true);
		system.add(planet5);
		Planet planet7 = new Planet(46.9642f, 360 * rand.nextFloat(),
				2.6945963f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet7);
		Planet satelite70 = new Planet(2.6945963f, 360 * rand.nextFloat(),
				1.174669f, CelestialBody.Celestial.PLANET_FOBOS, planet7, false);
		satelite70.sateliteRotationSpeed = 40.878056f;
		system.add(satelite70);
		Planet planet8 = new Planet(54.2816f, 360 * rand.nextFloat(),
				1.9255655f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet8);
		return star;
	}

	// FOMALHAUT
	public static Star fillSystemFomalhaut(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet0 = new Planet(6.805291f, 360 * rand.nextFloat(),
				1.9478247f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet0);
		Planet planet6 = new Planet(41.477146f, 360 * rand.nextFloat(),
				1.3554837f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(48.04326f, 360 * rand.nextFloat(),
				1.6345023f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet7);
		Planet planet9 = new Planet(62.50921f, 360 * rand.nextFloat(),
				2.0584483f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet9);
		return star;
	}

	// ALPHA_CRUCIS
	public static Star fillSystemAlpha_Crucis(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet2 = new Planet(18.070316f, 360 * rand.nextFloat(),
				2.559885f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet2);
		Planet planet4 = new Planet(29.510223f, 360 * rand.nextFloat(),
				2.4312725f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.20164f, 360 * rand.nextFloat(),
				1.7784147f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet5);
		Planet planet7 = new Planet(48.44451f, 360 * rand.nextFloat(),
				1.7931157f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet7);
		Planet satelite71 = new Planet(2.6717412f, 360 * rand.nextFloat(),
				0.6241868f, CelestialBody.Celestial.PLANET_CALISTO_GREEN,
				planet7, true);
		satelite71.sateliteRotationSpeed = 44.404194f;
		system.add(satelite71);
		Planet planet9 = new Planet(62.978745f, 360 * rand.nextFloat(),
				2.311753f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet9);
		Planet satelite91 = new Planet(3.2096915f, 360 * rand.nextFloat(),
				1.2274249f, CelestialBody.Celestial.PLANET_JUPITER_2, planet9, true);
		satelite91.sateliteRotationSpeed = -44.547432f;
		system.add(satelite91);
		return star;
	}

	// BETA_CRUCIS
	public static Star fillSystemBeta_Crucis(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(5.9652123f, 360 * rand.nextFloat(),
				2.1750531f, CelestialBody.Celestial.PLANET_6, star, false);
		system.add(planet0);
		Planet planet2 = new Planet(16.303963f, 360 * rand.nextFloat(),
				1.6127326f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet2);
		Planet planet5 = new Planet(40.88279f, 360 * rand.nextFloat(),
				2.708984f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet5);
		Planet satelite50 = new Planet(2.708984f, 360 * rand.nextFloat(),
				1.1706673f, CelestialBody.Celestial.PLANET_6, planet5, false);
		satelite50.sateliteRotationSpeed = 35.26265f;
		system.add(satelite50);
		Planet planet9 = new Planet(60.027054f, 360 * rand.nextFloat(),
				1.5268937f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet9);
		return star;
	}

	// GRAFIAS
	public static Star fillSystemGrafias(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet1 = new Planet(10.221831f, 360 * rand.nextFloat(),
				1.2531731f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet1);
		Planet satelite11 = new Planet(1.7542114f, 360 * rand.nextFloat(),
				1.0370345f, CelestialBody.Celestial.PLANET_CALISTO_1, planet1, false);
		satelite11.sateliteRotationSpeed = 42.82797f;
		system.add(satelite11);
		Planet planet3 = new Planet(23.197918f, 360 * rand.nextFloat(),
				1.6632712f, CelestialBody.Celestial.PLANET_4, star, true);
		system.add(planet3);
		Planet satelite31 = new Planet(2.2981386f, 360 * rand.nextFloat(),
				1.4836891f, CelestialBody.Celestial.PLANET_CALISTO_1, planet3, true);
		satelite31.sateliteRotationSpeed = 21.51762f;
		system.add(satelite31);
		Planet planet5 = new Planet(30.219143f, 360 * rand.nextFloat(),
				2.0268018f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet5);
		Planet planet6 = new Planet(43.389282f, 360 * rand.nextFloat(),
				2.9957056f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet6);
		return star;
	}

	// MARFAK
	public static Star fillSystemMarfak(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet0 = new Planet(4.060049f, 360 * rand.nextFloat(),
				2.4565616f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet0);
		Planet planet1 = new Planet(9.554723f, 360 * rand.nextFloat(),
				1.991313f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet1);
		Planet planet6 = new Planet(42.64305f, 360 * rand.nextFloat(),
				2.6070983f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet6);
		Planet planet8 = new Planet(55.02021f, 360 * rand.nextFloat(),
				1.3360337f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(61.70133f, 360 * rand.nextFloat(),
				1.6821421f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet9);
		return star;
	}

	// SEGIN
	public static Star fillSystemSegin(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet1 = new Planet(10.265795f, 360 * rand.nextFloat(),
				2.1427088f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(17.835184f, 360 * rand.nextFloat(),
				1.4271688f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet2);
		Planet planet3 = new Planet(25.411491f, 360 * rand.nextFloat(),
				2.6869473f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet3);
		Planet satelite32 = new Planet(3.1075444f, 360 * rand.nextFloat(),
				1.4406468f, CelestialBody.Celestial.PLANET_0, planet3, true);
		satelite32.sateliteRotationSpeed = -21.142439f;
		system.add(satelite32);
		Planet planet7 = new Planet(50.21611f, 360 * rand.nextFloat(),
				1.0132868f, CelestialBody.Celestial.PLANET_IO, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(56.802517f, 360 * rand.nextFloat(),
				2.6469755f, CelestialBody.Celestial.PLANET_CALISTO_1, star, false);
		system.add(planet8);
		Planet satelite80 = new Planet(2.6469755f, 360 * rand.nextFloat(),
				0.9598478f, CelestialBody.Celestial.PLANET_MIMAS, planet8, true);
		satelite80.sateliteRotationSpeed = 24.339848f;
		system.add(satelite80);
		Planet satelite82 = new Planet(4.503255f, 360 * rand.nextFloat(),
				0.89461666f, CelestialBody.Celestial.PLANET_MIMAS, planet8, true);
		satelite82.sateliteRotationSpeed = -44.054726f;
		system.add(satelite82);
		Planet planet9 = new Planet(62.315506f, 360 * rand.nextFloat(),
				2.4683523f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet9);
		return star;
	}

	// CANOPUS
	public static Star fillSystemCanopus(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet2 = new Planet(18.884869f, 360 * rand.nextFloat(),
				1.5343009f, CelestialBody.Celestial.PLANET_3, star, true);
		system.add(planet2);
		Planet satelite21 = new Planet(1.5647697f, 360 * rand.nextFloat(),
				0.85297114f, CelestialBody.Celestial.PLANET_JUPITER_0, planet2, false);
		satelite21.sateliteRotationSpeed = 46.087425f;
		system.add(satelite21);
		Planet planet4 = new Planet(30.186094f, 360 * rand.nextFloat(),
				2.0497227f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.268654f, 360 * rand.nextFloat(),
				1.0376614f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet5);
		Planet satelite52 = new Planet(1.9616711f, 360 * rand.nextFloat(),
				0.6953831f, CelestialBody.Celestial.PLANET_JUPITER_1, planet5, true);
		satelite52.sateliteRotationSpeed = -28.372128f;
		system.add(satelite52);
		Planet planet6 = new Planet(45.581448f, 360 * rand.nextFloat(),
				1.1590046f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet6);
		Planet planet8 = new Planet(53.752087f, 360 * rand.nextFloat(),
				2.62965f, CelestialBody.Celestial.PLANET_MIRANDA, star, false);
		system.add(planet8);
		Planet planet9 = new Planet(61.87594f, 360 * rand.nextFloat(),
				2.8928404f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet9);
		return star;
	}

	// THABIT
	public static Star fillSystemThabit(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet1 = new Planet(11.185918f, 360 * rand.nextFloat(),
				1.7746838f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(17.088163f, 360 * rand.nextFloat(),
				2.104825f, CelestialBody.Celestial.PLANET_6, star, false);
		system.add(planet2);
		Planet planet4 = new Planet(28.33463f, 360 * rand.nextFloat(),
				2.8989549f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.646706f, 360 * rand.nextFloat(),
				1.2721272f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet5);
		Planet satelite51 = new Planet(1.8587654f, 360 * rand.nextFloat(),
				0.72016567f, CelestialBody.Celestial.PLANET_CALISTO_0, planet5, true);
		satelite51.sateliteRotationSpeed = 32.848473f;
		system.add(satelite51);
		Planet planet6 = new Planet(45.640175f, 360 * rand.nextFloat(),
				1.6725708f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet6);
		Planet satelite62 = new Planet(3.4686632f, 360 * rand.nextFloat(),
				0.55764115f, CelestialBody.Celestial.PLANET_JUPITER_1, planet6, false);
		satelite62.sateliteRotationSpeed = -44.89642f;
		system.add(satelite62);
		Planet planet7 = new Planet(50.19739f, 360 * rand.nextFloat(),
				1.7599591f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(55.328564f, 360 * rand.nextFloat(),
				1.0309306f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(62.696667f, 360 * rand.nextFloat(),
				2.8876548f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet9);
		Planet satelite90 = new Planet(2.8876548f, 360 * rand.nextFloat(),
				0.6068585f, CelestialBody.Celestial.PLANET_FOBOS, planet9, false);
		satelite90.sateliteRotationSpeed = 29.895527f;
		system.add(satelite90);
		Planet satelite91 = new Planet(2.9028502f, 360 * rand.nextFloat(),
				0.89890826f, CelestialBody.Celestial.PLANET_FOBOS, planet9, true);
		satelite91.sateliteRotationSpeed = 34.143f;
		system.add(satelite91);
		return star;
	}

	// TEGMINE
	public static Star fillSystemTegmine(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet0 = new Planet(6.6629257f, 360 * rand.nextFloat(),
				1.2016602f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet0);
		Planet planet2 = new Planet(15.554862f, 360 * rand.nextFloat(),
				2.589197f, CelestialBody.Celestial.PLANET_JUPITER_1, star, false);
		system.add(planet2);
		Planet planet5 = new Planet(30.336018f, 360 * rand.nextFloat(),
				1.6933212f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet5);
		Planet satelite51 = new Planet(2.4530737f, 360 * rand.nextFloat(),
				0.66051733f, CelestialBody.Celestial.PLANET_CALISTO_GREEN,
				planet5, false);
		satelite51.sateliteRotationSpeed = -47.532406f;
		system.add(satelite51);
		Planet planet6 = new Planet(42.73043f, 360 * rand.nextFloat(),
				1.3206879f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet6);
		Planet planet7 = new Planet(48.38141f, 360 * rand.nextFloat(),
				2.6773143f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(54.90596f, 360 * rand.nextFloat(),
				1.270811f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(60.476597f, 360 * rand.nextFloat(),
				1.8297734f, CelestialBody.Celestial.PLANET_IO, star, false);
		system.add(planet9);
		Planet satelite91 = new Planet(1.8382132f, 360 * rand.nextFloat(),
				1.1916611f, CelestialBody.Celestial.PLANET_CALISTO_0, planet9, true);
		satelite91.sateliteRotationSpeed = 49.089447f;
		system.add(satelite91);
		Planet satelite92 = new Planet(2.7870455f, 360 * rand.nextFloat(),
				1.3163655f, CelestialBody.Celestial.PLANET_JUPITER_1, planet9, true);
		satelite92.sateliteRotationSpeed = -42.524555f;
		system.add(satelite92);
		return star;
	}

	// SIRIUS
	public static Star fillSystemSirius(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet1 = new Planet(11.940382f, 360 * rand.nextFloat(),
				1.2748357f, CelestialBody.Celestial.PLANET_EARTH, star, true);
		system.add(planet1);
		Planet planet3 = new Planet(24.0674f, 360 * rand.nextFloat(),
				2.6025763f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet3);
		Planet planet4 = new Planet(29.012873f, 360 * rand.nextFloat(),
				2.3093426f, CelestialBody.Celestial.PLANET_3, star, false);
		system.add(planet4);
		Planet planet6 = new Planet(42.243435f, 360 * rand.nextFloat(),
				2.8293111f, CelestialBody.Celestial.PLANET_4, star, false);
		system.add(planet6);
		Planet satelite62 = new Planet(4.4333224f, 360 * rand.nextFloat(),
				0.8292789f, CelestialBody.Celestial.PLANET_0, planet6, false);
		satelite62.sateliteRotationSpeed = -37.66269f;
		system.add(satelite62);
		Planet planet7 = new Planet(48.636654f, 360 * rand.nextFloat(),
				1.7934114f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet7);
		Planet satelite70 = new Planet(1.7934114f, 360 * rand.nextFloat(),
				1.388679f, CelestialBody.Celestial.PLANET_FOBOS, planet7, false);
		satelite70.sateliteRotationSpeed = -35.90355f;
		system.add(satelite70);
		Planet satelite71 = new Planet(2.6341598f, 360 * rand.nextFloat(),
				1.0078883f, CelestialBody.Celestial.PLANET_3, planet7, true);
		satelite71.sateliteRotationSpeed = -41.075127f;
		system.add(satelite71);
		Planet planet9 = new Planet(61.114277f, 360 * rand.nextFloat(),
				2.5593863f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet9);
		return star;
	}

	// ALPHA_CENTAURI
	public static Star fillSystemAlpha_Centauri(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet2 = new Planet(17.76796f, 360 * rand.nextFloat(),
				2.0224266f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet2);
		Planet planet4 = new Planet(30.421509f, 360 * rand.nextFloat(),
				1.6760924f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet4);
		Planet satelite40 = new Planet(1.6760924f, 360 * rand.nextFloat(),
				0.72289413f, CelestialBody.Celestial.PLANET_5, planet4, true);
		satelite40.sateliteRotationSpeed = 23.561373f;
		system.add(satelite40);
		Planet planet6 = new Planet(40.77638f, 360 * rand.nextFloat(),
				2.8816419f, CelestialBody.Celestial.PLANET_IO, star, false);
		system.add(planet6);
		Planet planet9 = new Planet(62.12721f, 360 * rand.nextFloat(),
				2.506224f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet9);
		return star;
	}

	// VEGA
	public static Star fillSystemVega(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet1 = new Planet(9.302153f, 360 * rand.nextFloat(),
				2.8777962f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet1);
		Planet planet3 = new Planet(24.953333f, 360 * rand.nextFloat(),
				1.4339429f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet3);
		Planet planet5 = new Planet(30.11558f, 360 * rand.nextFloat(),
				2.0867503f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet5);
		Planet planet7 = new Planet(47.97971f, 360 * rand.nextFloat(),
				2.3412855f, CelestialBody.Celestial.PLANET_CALISTO_1, star, false);
		system.add(planet7);
		return star;
	}

	// ADHAFERA
	public static Star fillSystemAdhafera(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet1 = new Planet(12.812243f, 360 * rand.nextFloat(),
				2.3215408f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet1);
		Planet satelite10 = new Planet(2.3215408f, 360 * rand.nextFloat(),
				0.59549874f, CelestialBody.Celestial.PLANET_JUPITER_1, planet1, false);
		satelite10.sateliteRotationSpeed = 28.85574f;
		system.add(satelite10);
		Planet planet2 = new Planet(16.11151f, 360 * rand.nextFloat(),
				2.590776f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet2);
		Planet planet5 = new Planet(30.432426f, 360 * rand.nextFloat(),
				2.2845826f, CelestialBody.Celestial.PLANET_MIRANDA, star, false);
		system.add(planet5);
		Planet planet6 = new Planet(43.551403f, 360 * rand.nextFloat(),
				2.5610485f, CelestialBody.Celestial.PLANET_JUPITER_1, star, true);
		system.add(planet6);
		Planet planet8 = new Planet(56.94712f, 360 * rand.nextFloat(),
				2.3491292f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet8);
		return star;
	}

	// BETELGEUSE
	public static Star fillSystemBetelgeuse(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet0 = new Planet(5.6938725f, 360 * rand.nextFloat(),
				1.4169165f, CelestialBody.Celestial.PLANET_4, star, true);
		system.add(planet0);
		Planet satelite00 = new Planet(1.4169165f, 360 * rand.nextFloat(),
				0.70845824f, CelestialBody.Celestial.PLANET_IO, planet0, true);
		satelite00.sateliteRotationSpeed = 22.759092f;
		system.add(satelite00);
		Planet planet2 = new Planet(16.755333f, 360 * rand.nextFloat(),
				2.3254614f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet2);
		Planet satelite21 = new Planet(2.9077573f, 360 * rand.nextFloat(),
				1.1866622f, CelestialBody.Celestial.PLANET_JUPITER_0, planet2, true);
		satelite21.sateliteRotationSpeed = 36.52796f;
		system.add(satelite21);
		Planet planet3 = new Planet(24.49374f, 360 * rand.nextFloat(),
				1.8276178f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet3);
		Planet planet5 = new Planet(30.654514f, 360 * rand.nextFloat(),
				2.890691f, CelestialBody.Celestial.PLANET_0, star, false);
		system.add(planet5);
		Planet planet6 = new Planet(44.304672f, 360 * rand.nextFloat(),
				1.6066058f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet6);
		Planet planet8 = new Planet(53.205566f, 360 * rand.nextFloat(),
				2.7434447f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet8);
		return star;
	}

	// SPICA
	public static Star fillSystemSpica(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet1 = new Planet(10.233519f, 360 * rand.nextFloat(),
				2.5933657f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet1);
		Planet satelite11 = new Planet(3.0263083f, 360 * rand.nextFloat(),
				1.1479026f, CelestialBody.Celestial.PLANET_5, planet1, true);
		satelite11.sateliteRotationSpeed = -49.18097f;
		system.add(satelite11);
		Planet planet2 = new Planet(15.628485f, 360 * rand.nextFloat(),
				1.6151044f, CelestialBody.Celestial.PLANET_MIRANDA, star, false);
		system.add(planet2);
		Planet satelite22 = new Planet(2.2500074f, 360 * rand.nextFloat(),
				0.64515275f, CelestialBody.Celestial.PLANET_5, planet2, true);
		satelite22.sateliteRotationSpeed = 31.360165f;
		system.add(satelite22);
		Planet planet3 = new Planet(24.053997f, 360 * rand.nextFloat(),
				2.5886636f, CelestialBody.Celestial.PLANET_IO, star, false);
		system.add(planet3);
		Planet planet7 = new Planet(47.259937f, 360 * rand.nextFloat(),
				1.3456405f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet7);
		Planet planet9 = new Planet(61.549107f, 360 * rand.nextFloat(),
				1.4325297f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet9);
		return star;
	}

	// ANTARES
	public static Star fillSystemAntares(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet3 = new Planet(23.046223f, 360 * rand.nextFloat(),
				2.0059366f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet3);
		Planet planet4 = new Planet(31.622276f, 360 * rand.nextFloat(),
				2.8934302f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.03351f, 360 * rand.nextFloat(),
				1.3091844f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet5);
		Planet planet7 = new Planet(49.739964f, 360 * rand.nextFloat(),
				1.3019471f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(56.966797f, 360 * rand.nextFloat(),
				1.3995776f, CelestialBody.Celestial.PLANET_7, star, false);
		system.add(planet8);
		return star;
	}

	// POLLUX
	public static Star fillSystemPollux(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_YELLOW);
		system.add(star);
		Planet planet2 = new Planet(15.9322195f, 360 * rand.nextFloat(),
				2.0684757f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet2);
		Planet planet4 = new Planet(29.478336f, 360 * rand.nextFloat(),
				1.3176156f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.134792f, 360 * rand.nextFloat(),
				1.5411344f, CelestialBody.Celestial.PLANET_4, star, true);
		system.add(planet5);
		Planet satelite52 = new Planet(1.7191465f, 360 * rand.nextFloat(),
				0.8081345f, CelestialBody.Celestial.PLANET_5, planet5, false);
		satelite52.sateliteRotationSpeed = 45.5028f;
		system.add(satelite52);
		Planet planet6 = new Planet(45.115974f, 360 * rand.nextFloat(),
				2.8666828f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet6);
		Planet planet7 = new Planet(50.03052f, 360 * rand.nextFloat(),
				1.9383551f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet7);
		Planet satelite70 = new Planet(1.9383551f, 360 * rand.nextFloat(),
				0.5977773f, CelestialBody.Celestial.PLANET_MIRANDA, planet7, true);
		satelite70.sateliteRotationSpeed = -36.027008f;
		system.add(satelite70);
		Planet planet8 = new Planet(54.62923f, 360 * rand.nextFloat(),
				2.7484498f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(59.30924f, 360 * rand.nextFloat(),
				1.3938321f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet9);
		return star;
	}

	// DENEB
	public static Star fillSystemDeneb(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet0 = new Planet(4.185847f, 360 * rand.nextFloat(),
				1.8949612f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet0);
		Planet planet2 = new Planet(16.574953f, 360 * rand.nextFloat(),
				2.8046825f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet2);
		Planet planet3 = new Planet(24.999472f, 360 * rand.nextFloat(),
				2.4946773f, CelestialBody.Celestial.PLANET_MIMAS, star, false);
		system.add(planet3);
		Planet planet7 = new Planet(49.14746f, 360 * rand.nextFloat(),
				2.161902f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet7);
		Planet planet9 = new Planet(62.61533f, 360 * rand.nextFloat(),
				2.6681156f, CelestialBody.Celestial.PLANET_7, star, false);
		system.add(planet9);
		Planet satelite92 = new Planet(3.5248797f, 360 * rand.nextFloat(),
				1.4460027f, CelestialBody.Celestial.PLANET_CALISTO_0, planet9, true);
		satelite92.sateliteRotationSpeed = -43.068913f;
		system.add(satelite92);
		return star;
	}

	// ALRAI
	public static Star fillSystemAlrai(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet1 = new Planet(9.257986f, 360 * rand.nextFloat(),
				1.4269952f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(15.945728f, 360 * rand.nextFloat(),
				2.1345243f, CelestialBody.Celestial.PLANET_MIRANDA, star, false);
		system.add(planet2);
		Planet satelite22 = new Planet(3.7980142f, 360 * rand.nextFloat(),
				0.64471227f, CelestialBody.Celestial.PLANET_0, planet2, true);
		satelite22.sateliteRotationSpeed = 28.634514f;
		system.add(satelite22);
		Planet planet3 = new Planet(25.537483f, 360 * rand.nextFloat(),
				1.0872451f, CelestialBody.Celestial.PLANET_CALISTO_1, star, false);
		system.add(planet3);
		Planet planet4 = new Planet(29.359451f, 360 * rand.nextFloat(),
				2.33108f, CelestialBody.Celestial.PLANET_JUPITER_1, star, true);
		system.add(planet4);
		Planet planet6 = new Planet(41.168205f, 360 * rand.nextFloat(),
				2.957179f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet6);
		Planet satelite62 = new Planet(4.4454575f, 360 * rand.nextFloat(),
				1.3236237f, CelestialBody.Celestial.PLANET_CALISTO_1, planet6, false);
		satelite62.sateliteRotationSpeed = -48.06563f;
		system.add(satelite62);
		Planet planet7 = new Planet(47.506603f, 360 * rand.nextFloat(),
				2.460754f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet7);
		return star;
	}

	// TURAIS
	public static Star fillSystemTurais(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet0 = new Planet(3.3817039f, 360 * rand.nextFloat(),
				2.774248f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet0);
		Planet satelite02 = new Planet(2.8624518f, 360 * rand.nextFloat(),
				0.94721425f, CelestialBody.Celestial.PLANET_0, planet0, false);
		satelite02.sateliteRotationSpeed = -27.430271f;
		system.add(satelite02);
		Planet planet4 = new Planet(30.992931f, 360 * rand.nextFloat(),
				1.9848106f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet4);
		Planet planet6 = new Planet(42.514946f, 360 * rand.nextFloat(),
				1.0390869f, CelestialBody.Celestial.PLANET_CALISTO_1, star, false);
		system.add(planet6);
		Planet planet8 = new Planet(54.98107f, 360 * rand.nextFloat(),
				1.484145f, CelestialBody.Celestial.PLANET_CALISTO_GREEN, star, true);
		system.add(planet8);
		return star;
	}

	// ARCTURUS
	public static Star fillSystemArcturus(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet0 = new Planet(6.9339647f, 360 * rand.nextFloat(),
				2.1482325f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet0);
		Planet planet2 = new Planet(16.100124f, 360 * rand.nextFloat(),
				1.2776318f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet2);
		Planet planet3 = new Planet(23.884964f, 360 * rand.nextFloat(),
				1.3677596f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet3);
		Planet planet7 = new Planet(48.376934f, 360 * rand.nextFloat(),
				1.3884549f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(54.377827f, 360 * rand.nextFloat(),
				2.3522286f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet8);
		Planet planet9 = new Planet(61.20287f, 360 * rand.nextFloat(),
				1.5994031f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet9);
		return star;
	}

	// BELLATRIX
	public static Star fillSystemBellatrix(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet2 = new Planet(18.031298f, 360 * rand.nextFloat(),
				1.4594713f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet2);
		Planet planet4 = new Planet(28.02407f, 360 * rand.nextFloat(),
				2.08855f, CelestialBody.Celestial.PLANET_0, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.533604f, 360 * rand.nextFloat(),
				2.6136732f, CelestialBody.Celestial.PLANET_MIMAS, star, true);
		system.add(planet5);
		Planet satelite52 = new Planet(3.2984848f, 360 * rand.nextFloat(),
				1.342926f, CelestialBody.Celestial.PLANET_EARTH_GREEN, planet5, false);
		satelite52.sateliteRotationSpeed = -41.533573f;
		system.add(satelite52);
		Planet planet8 = new Planet(56.127697f, 360 * rand.nextFloat(),
				2.3923311f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet8);
		Planet satelite82 = new Planet(3.0271952f, 360 * rand.nextFloat(),
				0.5235421f, CelestialBody.Celestial.PLANET_0, planet8, false);
		satelite82.sateliteRotationSpeed = 23.491194f;
		system.add(satelite82);
		return star;
	}

	// CASTOR
	public static Star fillSystemCastor(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet0 = new Planet(6.3443503f, 360 * rand.nextFloat(),
				1.7569355f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet0);
		return star;
	}

	// ELECTRA
	public static Star fillSystemElectra(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(5.781645f, 360 * rand.nextFloat(),
				1.5874358f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet0);
		Planet satelite02 = new Planet(1.6404659f, 360 * rand.nextFloat(),
				0.74784416f, CelestialBody.Celestial.PLANET_EARTH_GREEN,
				planet0, true);
		satelite02.sateliteRotationSpeed = 37.461227f;
		system.add(satelite02);
		Planet planet1 = new Planet(11.1439085f, 360 * rand.nextFloat(),
				1.4782932f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet1);
		Planet satelite10 = new Planet(1.4782932f, 360 * rand.nextFloat(),
				0.5054695f, CelestialBody.Celestial.PLANET_JUPITER_0, planet1, false);
		satelite10.sateliteRotationSpeed = -37.333294f;
		system.add(satelite10);
		Planet planet2 = new Planet(17.32508f, 360 * rand.nextFloat(),
				2.8426328f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet2);
		Planet planet5 = new Planet(30.016296f, 360 * rand.nextFloat(),
				2.3727763f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet5);
		Planet planet6 = new Planet(46.260696f, 360 * rand.nextFloat(),
				2.7657957f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet6);
		Planet satelite61 = new Planet(3.0185277f, 360 * rand.nextFloat(),
				1.1380031f, CelestialBody.Celestial.PLANET_JUPITER_0, planet6, false);
		satelite61.sateliteRotationSpeed = -20.11643f;
		system.add(satelite61);
		Planet planet7 = new Planet(50.027695f, 360 * rand.nextFloat(),
				2.5749035f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet7);
		Planet satelite72 = new Planet(3.4896026f, 360 * rand.nextFloat(),
				1.3553296f, CelestialBody.Celestial.PLANET_4, planet7, true);
		satelite72.sateliteRotationSpeed = -31.458012f;
		system.add(satelite72);
		return star;
	}

	// KEID
	public static Star fillSystemKeid(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_VIOLET);
		system.add(star);
		Planet planet1 = new Planet(9.569288f, 360 * rand.nextFloat(),
				2.6767063f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(16.810814f, 360 * rand.nextFloat(),
				2.5798042f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet2);
		Planet satelite22 = new Planet(4.3151445f, 360 * rand.nextFloat(),
				0.6933322f, CelestialBody.Celestial.PLANET_JUPITER_1, planet2, false);
		satelite22.sateliteRotationSpeed = -28.794178f;
		system.add(satelite22);
		Planet planet3 = new Planet(25.072937f, 360 * rand.nextFloat(),
				2.8521461f, CelestialBody.Celestial.PLANET_MOON_0, star, false);
		system.add(planet3);
		Planet satelite32 = new Planet(3.886157f, 360 * rand.nextFloat(),
				1.1521474f, CelestialBody.Celestial.PLANET_MOON_0, planet3, true);
		satelite32.sateliteRotationSpeed = 34.94596f;
		system.add(satelite32);
		Planet planet5 = new Planet(30.7433f, 360 * rand.nextFloat(),
				1.6354064f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet5);
		Planet planet6 = new Planet(41.259056f, 360 * rand.nextFloat(),
				1.8924427f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(46.9978f, 360 * rand.nextFloat(),
				1.0336791f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(54.683586f, 360 * rand.nextFloat(),
				2.8832955f, CelestialBody.Celestial.PLANET_TRITON, star, true);
		system.add(planet8);
		return star;
	}

	// SHARATAN
	public static Star fillSystemSharatan(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet1 = new Planet(10.830619f, 360 * rand.nextFloat(),
				2.8689566f, CelestialBody.Celestial.PLANET_CALISTO_0, star, false);
		system.add(planet1);
		Planet planet4 = new Planet(30.212343f, 360 * rand.nextFloat(),
				2.3326309f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet4);
		Planet satelite41 = new Planet(3.22164f, 360 * rand.nextFloat(),
				1.4091077f, CelestialBody.Celestial.PLANET_1, planet4, false);
		satelite41.sateliteRotationSpeed = -23.19221f;
		system.add(satelite41);
		Planet planet8 = new Planet(54.076405f, 360 * rand.nextFloat(),
				2.7870734f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet8);
		Planet satelite80 = new Planet(2.7870734f, 360 * rand.nextFloat(),
				0.68553215f, CelestialBody.Celestial.PLANET_4, planet8, false);
		satelite80.sateliteRotationSpeed = 34.633625f;
		system.add(satelite80);
		return star;
	}

	// REGULUS
	public static Star fillSystemRegulus(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet3 = new Planet(23.065775f, 360 * rand.nextFloat(),
				2.7921047f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet3);
		Planet satelite30 = new Planet(2.7921047f, 360 * rand.nextFloat(),
				1.3219743f, CelestialBody.Celestial.PLANET_CALISTO_0, planet3, false);
		satelite30.sateliteRotationSpeed = -26.191956f;
		system.add(satelite30);
		Planet planet4 = new Planet(29.950575f, 360 * rand.nextFloat(),
				1.7975585f, CelestialBody.Celestial.PLANET_0, star, true);
		system.add(planet4);
		Planet satelite41 = new Planet(2.489496f, 360 * rand.nextFloat(),
				0.6159671f, CelestialBody.Celestial.PLANET_7, planet4, false);
		satelite41.sateliteRotationSpeed = 44.19746f;
		system.add(satelite41);
		Planet planet5 = new Planet(40.21456f, 360 * rand.nextFloat(),
				1.7590088f, CelestialBody.Celestial.PLANET_FOBOS, star, true);
		system.add(planet5);
		Planet planet8 = new Planet(55.503433f, 360 * rand.nextFloat(),
				1.1299361f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet8);
		Planet planet9 = new Planet(59.442406f, 360 * rand.nextFloat(),
				2.3726356f, CelestialBody.Celestial.PLANET_4, star, false);
		system.add(planet9);
		Planet satelite90 = new Planet(2.3726356f, 360 * rand.nextFloat(),
				1.1349627f, CelestialBody.Celestial.PLANET_CALISTO_1, planet9, true);
		satelite90.sateliteRotationSpeed = 38.021782f;
		system.add(satelite90);
		Planet satelite92 = new Planet(2.3777685f, 360 * rand.nextFloat(),
				0.7217676f, CelestialBody.Celestial.PLANET_EARTH_GREEN, planet9, true);
		satelite92.sateliteRotationSpeed = 21.554058f;
		system.add(satelite92);
		return star;
	}

	// MIMOSA
	public static Star fillSystemMimosa(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet0 = new Planet(5.6583595f, 360 * rand.nextFloat(),
				1.9611264f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet0);
		Planet planet4 = new Planet(29.159353f, 360 * rand.nextFloat(),
				2.8753567f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet4);
		Planet satelite40 = new Planet(2.8753567f, 360 * rand.nextFloat(),
				0.9327386f, CelestialBody.Celestial.PLANET_3, planet4, true);
		satelite40.sateliteRotationSpeed = 20.65261f;
		system.add(satelite40);
		Planet planet5 = new Planet(40.31002f, 360 * rand.nextFloat(),
				2.216032f, CelestialBody.Celestial.PLANET_1, star, false);
		system.add(planet5);
		Planet planet6 = new Planet(45.648754f, 360 * rand.nextFloat(),
				1.0984489f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet6);
		Planet planet8 = new Planet(53.429188f, 360 * rand.nextFloat(),
				1.1183724f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet8);
		Planet satelite81 = new Planet(1.9112055f, 360 * rand.nextFloat(),
				1.0078208f, CelestialBody.Celestial.PLANET_TRITON, planet8, false);
		satelite81.sateliteRotationSpeed = 22.728535f;
		system.add(satelite81);
		return star;
	}

	// WEZEN
	public static Star fillSystemWezen(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet0 = new Planet(4.6640205f, 360 * rand.nextFloat(),
				1.1009004f, CelestialBody.Celestial.PLANET_MOON_0, star, true);
		system.add(planet0);
		Planet planet2 = new Planet(16.019108f, 360 * rand.nextFloat(),
				2.4098954f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet2);
		Planet satelite21 = new Planet(2.7251844f, 360 * rand.nextFloat(),
				1.0510548f, CelestialBody.Celestial.PLANET_CALISTO_GREEN,
				planet2, false);
		satelite21.sateliteRotationSpeed = -36.156113f;
		system.add(satelite21);
		Planet satelite22 = new Planet(2.740774f, 360 * rand.nextFloat(),
				1.1827135f, CelestialBody.Celestial.PLANET_MIMAS, planet2, false);
		satelite22.sateliteRotationSpeed = -33.319885f;
		system.add(satelite22);
		Planet planet4 = new Planet(31.00619f, 360 * rand.nextFloat(),
				1.3070962f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet4);
		Planet satelite40 = new Planet(1.3070962f, 360 * rand.nextFloat(),
				0.5287697f, CelestialBody.Celestial.PLANET_GANYMEDE, planet4, true);
		satelite40.sateliteRotationSpeed = -42.050636f;
		system.add(satelite40);
		Planet planet7 = new Planet(50.239105f, 360 * rand.nextFloat(),
				1.6993731f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(53.824482f, 360 * rand.nextFloat(),
				2.3923383f, CelestialBody.Celestial.PLANET_JUPITER_2, star, true);
		system.add(planet8);
		Planet satelite81 = new Planet(3.11549f, 360 * rand.nextFloat(),
				0.6818768f, CelestialBody.Celestial.PLANET_CALISTO_1, planet8, true);
		satelite81.sateliteRotationSpeed = 46.769623f;
		system.add(satelite81);
		Planet satelite82 = new Planet(3.0249467f, 360 * rand.nextFloat(),
				0.750515f, CelestialBody.Celestial.PLANET_JUPITER_0, planet8, false);
		satelite82.sateliteRotationSpeed = -29.54794f;
		system.add(satelite82);
		return star;
	}

	// PISCES
	public static Star fillSystemPisces(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet1 = new Planet(12.827193f, 360 * rand.nextFloat(),
				2.8024588f, CelestialBody.Celestial.PLANET_5, star, true);
		system.add(planet1);
		Planet planet3 = new Planet(24.836918f, 360 * rand.nextFloat(),
				2.3175893f, CelestialBody.Celestial.PLANET_CALISTO_0, star, true);
		system.add(planet3);
		Planet planet5 = new Planet(30.49832f, 360 * rand.nextFloat(),
				2.050181f, CelestialBody.Celestial.PLANET_TRITON, star, false);
		system.add(planet5);
		Planet planet6 = new Planet(43.790775f, 360 * rand.nextFloat(),
				1.7655739f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet6);
		Planet planet9 = new Planet(59.841526f, 360 * rand.nextFloat(),
				2.5513248f, CelestialBody.Celestial.PLANET_MOON_0, star, false);
		system.add(planet9);
		Planet satelite90 = new Planet(2.5513248f, 360 * rand.nextFloat(),
				0.92822236f, CelestialBody.Celestial.PLANET_6, planet9, true);
		satelite90.sateliteRotationSpeed = -27.291056f;
		system.add(satelite90);
		return star;
	}

	// ARIES
	public static Star fillSystemAries(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_BLUE);
		system.add(star);
		Planet planet0 = new Planet(5.1154366f, 360 * rand.nextFloat(),
				2.9051137f, CelestialBody.Celestial.PLANET_7, star, false);
		system.add(planet0);
		Planet planet1 = new Planet(11.616966f, 360 * rand.nextFloat(),
				1.5054272f, CelestialBody.Celestial.PLANET_JUPITER_0, star, true);
		system.add(planet1);
		Planet planet2 = new Planet(18.392908f, 360 * rand.nextFloat(),
				1.9237964f, CelestialBody.Celestial.PLANET_JUPITER_1, star, true);
		system.add(planet2);
		Planet planet3 = new Planet(25.156645f, 360 * rand.nextFloat(),
				2.5103016f, CelestialBody.Celestial.PLANET_MIMAS, star, false);
		system.add(planet3);
		Planet planet4 = new Planet(30.033598f, 360 * rand.nextFloat(),
				2.0855303f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet4);
		Planet planet5 = new Planet(40.38702f, 360 * rand.nextFloat(),
				1.4280928f, CelestialBody.Celestial.PLANET_CALISTO_1, star, true);
		system.add(planet5);
		Planet planet7 = new Planet(50.113358f, 360 * rand.nextFloat(),
				1.9090759f, CelestialBody.Celestial.PLANET_JUPITER_2, star, false);
		system.add(planet7);
		Planet planet8 = new Planet(53.22337f, 360 * rand.nextFloat(),
				1.6003457f, CelestialBody.Celestial.PLANET_MIRANDA, star, true);
		system.add(planet8);
		Planet satelite82 = new Planet(3.0532024f, 360 * rand.nextFloat(),
				0.6435779f, CelestialBody.Celestial.PLANET_CALISTO_0, planet8, true);
		satelite82.sateliteRotationSpeed = 48.934895f;
		system.add(satelite82);
		Planet planet9 = new Planet(59.34377f, 360 * rand.nextFloat(),
				1.0395721f, CelestialBody.Celestial.PLANET_JUPITER_0, star, false);
		system.add(planet9);
		Planet satelite91 = new Planet(1.5480101f, 360 * rand.nextFloat(),
				0.9623482f, CelestialBody.Celestial.PLANET_JUPITER_0, planet9, true);
		satelite91.sateliteRotationSpeed = -32.476738f;
		system.add(satelite91);
		return star;
	}

	// FURUD
	public static Star fillSystemFurud(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet0 = new Planet(5.1708174f, 360 * rand.nextFloat(),
				2.5795722f, CelestialBody.Celestial.PLANET_3, star, true);
		system.add(planet0);
		Planet planet3 = new Planet(23.4147f, 360 * rand.nextFloat(),
				2.939568f, CelestialBody.Celestial.PLANET_5, star, false);
		system.add(planet3);
		Planet planet4 = new Planet(30.447424f, 360 * rand.nextFloat(),
				1.808198f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet4);
		Planet planet8 = new Planet(54.290653f, 360 * rand.nextFloat(),
				2.0278773f, CelestialBody.Celestial.PLANET_GANYMEDE, star, true);
		system.add(planet8);
		return star;
	}

	// NUSAKAN
	public static Star fillSystemNusakan(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_RED);
		system.add(star);
		Planet planet0 = new Planet(6.4218187f, 360 * rand.nextFloat(),
				1.5041947f, CelestialBody.Celestial.PLANET_1, star, true);
		system.add(planet0);
		Planet planet4 = new Planet(30.546894f, 360 * rand.nextFloat(),
				1.5557283f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, false);
		system.add(planet4);
		Planet planet5 = new Planet(40.415333f, 360 * rand.nextFloat(),
				1.9015284f, CelestialBody.Celestial.PLANET_JUPITER_1, star, true);
		system.add(planet5);
		Planet planet6 = new Planet(45.11707f, 360 * rand.nextFloat(),
				1.2432752f, CelestialBody.Celestial.PLANET_FOBOS, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(49.05562f, 360 * rand.nextFloat(),
				2.7154458f, CelestialBody.Celestial.PLANET_6, star, true);
		system.add(planet7);
		Planet satelite70 = new Planet(2.7154458f, 360 * rand.nextFloat(),
				0.69446385f, CelestialBody.Celestial.PLANET_MIMAS, planet7, false);
		satelite70.sateliteRotationSpeed = -42.2619f;
		system.add(satelite70);
		Planet satelite71 = new Planet(3.673965f, 360 * rand.nextFloat(),
				0.83544105f, CelestialBody.Celestial.PLANET_CALISTO_GREEN,
				planet7, true);
		satelite71.sateliteRotationSpeed = 24.626966f;
		system.add(satelite71);
		Planet planet8 = new Planet(56.336853f, 360 * rand.nextFloat(),
				2.2559059f, CelestialBody.Celestial.PLANET_IO, star, true);
		system.add(planet8);
		Planet satelite80 = new Planet(2.2559059f, 360 * rand.nextFloat(),
				0.55851275f, CelestialBody.Celestial.PLANET_7, planet8, false);
		satelite80.sateliteRotationSpeed = 36.417908f;
		system.add(satelite80);
		Planet planet9 = new Planet(61.06716f, 360 * rand.nextFloat(),
				1.882284f, CelestialBody.Celestial.PLANET_EARTH_GREEN, star, true);
		system.add(planet9);
		return star;
	}

	// MINKAR
	public static Star fillSystemMinkar(List<CelestialBody> system, Random rand) {
		Star star = new Star(World.WORLD_WIDTH / 2, World.WORLD_HEIGHT / 2, 4f,
				CelestialBody.Celestial.STAR_CYAN);
		system.add(star);
		Planet planet2 = new Planet(17.043465f, 360 * rand.nextFloat(),
				2.4038873f, CelestialBody.Celestial.PLANET_7, star, true);
		system.add(planet2);
		Planet planet6 = new Planet(42.233826f, 360 * rand.nextFloat(),
				2.226584f, CelestialBody.Celestial.PLANET_MIMAS, star, false);
		system.add(planet6);
		Planet planet7 = new Planet(48.581673f, 360 * rand.nextFloat(),
				1.3264341f, CelestialBody.Celestial.PLANET_2, star, true);
		system.add(planet7);
		Planet planet8 = new Planet(56.894238f, 360 * rand.nextFloat(),
				1.1262515f, CelestialBody.Celestial.PLANET_MOON_0, star, false);
		system.add(planet8);
		return star;
	}
}
