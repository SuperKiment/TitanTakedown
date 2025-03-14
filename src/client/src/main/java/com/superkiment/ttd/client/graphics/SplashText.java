package com.superkiment.ttd.client.graphics;

public class SplashText {
    static String[] splashTexts = {
            "Le sol tremble sous tes pas...",
            "Un titan rôde dans les parages.",
            "Survivre ou périr, à toi de choisir.",
            "Le ciel s'assombrit au loin.",
            "Un bruit sourd résonne au loin...",
            "Les titans n'ont aucune pitié.",
            "L'acier grince sous la pression...",
            "Tes choix écrivent ton destin.",
            "Un colosse s'éveille dans l'ombre.",
            "Les légendes parlent de géants...",
            "Chaque pas pourrait être le dernier.",
            "Les ruines cachent d'anciens secrets.",
            "Un rugissement fend l'horizon...",
            "Les cendres recouvrent le sol.",
            "Le temps est contre toi.",
            "Les machines ont une volonté propre.",
            "Un œil rouge brille dans la nuit...",
            "Les survivants se font rares.",
            "Une ombre massive te surplombe.",
            "L'adrénaline monte...",
            "Les Titans ne dorment jamais, ils te traquent à chaque pas.",
            "Tu veux tuer un Titan ? Prépare-toi à perdre bien plus que du temps.",
            "Fuir ou combattre, deux choix, une seule survie.",
            "Attention, un Titan approche. Cache-toi vite !",
            "L'arène est prête. Qui sera le prochain à tomber ?",
            "Les créatures mécaniques ont une force de fer, mais les organiques… sont imprévisibles.",
            "Ton équipement est ta seule chance de survie. Ne le néglige pas.",
            "Ne sous-estime jamais un Titan. Même un faux mouvement peut être fatal.",
            "Les armes peuvent tuer des Titans, mais la stratégie te permettra de survivre.",
            "Les Titans ne pardonnent pas. Mais eux, tu peux les défier.",
            "L'environnement cache des secrets. Prends garde à tout ce qui semble étrange.",
            "Fais attention à la nuit… Les monstres deviennent encore plus féroces.",
            "Le silence avant la tempête est presque aussi menaçant que le rugissement d'un Titan.",
            "Un Titan abattu est une victoire, mais la guerre ne fait que commencer.",
            "Ce terrain cache des dangers invisibles. Sois toujours sur tes gardes.",
            "Un Titan mécanique peut te broyer, mais un Titan organique te brisera l'âme.",
            "Les Titans sont forts, mais même les plus puissants peuvent être piégés.",
            "Ta survie dépendra de ton intelligence, pas seulement de ta force.",
            "Un monstre détruit tout sur son passage. Si tu n'es pas prêt, tu seras la prochaine victime.",
            "Les Titans arrivent en meute, mais un héros sait comment les affronter.",
            "Les créatures mécaniques ont des failles. Apprends-les avant qu'elles ne te fassent tomber.",
            "Tant que tu vis, tu as une chance. Mais la chance n’est pas éternelle.",
            "Ils ne s'arrêteront pas. Ni toi, ni eux.",
            "La stratégie, c'est ton alliée. L'armement, ton outil.",
            "L'odeur du métal est partout. Est-ce la fin ou un nouveau début ?",
            "Un Titan ne meurt pas facilement. Prépare-toi pour une longue bataille.",
            "Les Titans ne sont pas tes seuls ennemis. La nature elle-même peut t'engloutir.",
            "Ne sois pas trop confiant. Un faux pas et tout peut basculer.",
            "Ton feu de camp est ton dernier refuge. Mais combien de temps tiendra-t-il ?",
            "L'ombre d'un Titan est plus grande que son rugissement."
    };

    public static String getRandom() {
        int index = (int) Math.floor(Math.random() * splashTexts.length);
        return splashTexts[index];
    }
}
