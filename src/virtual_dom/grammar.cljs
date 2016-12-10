(ns virtual-dom.grammar)

(def default-grammar
  '{:-> [:dress-up :locations :play-time :play-time :finish]
    :dress-up ["Put on "
               (:makeup
                :underwear :underwear
                :kinkywear :kinkywear
                [:makeup " and " :underwear]
                [:makeup " and " :kinkywear])
               ". "]

    :makeup ("your darkest lipstick"
             "pretty pink lipstick")

    :underwear (:undies :socks [:undies " and " :socks])

    :undies ("your most revealing pair of undies"
             "bright flamboyant undies"
             "your fanciest pair of underwear")

    :socks ("thigh highs"
            "colorful socks")

    :kinkywear ("nipple clamps"
                "clothespins on a sensitive area"
                "a gag"
                "a blindfold"
                "a blindfold and a gag"
                "a gag and nipple clamps")

    :locations ["Go to "
                ("the bathroom"
                 "your bedroom"
                 "on a comfortable chair"
                 "the shower")
                ". "]

    :play-time (:tease
                [:tease " and " :substimulate]
                :obey :obey
                :punish
                [:punish " and " :substimulate])

    :roughness ("hard" "lightly")

    :tease ["Tease your " :tease* "."]
    :subtease ["tease your " :tease*]
    :tease* [("anus" "genitals" "nipples" "breasts" "neck" "butt" "back")
             " with "
             ("ice" "something hot" "a feather" "your hands" "a shock wand")]

    :obey (["On your knees with your your ass up and your head down, "
            (:subspank :subtease) "."]
           ["Sit with your legs spread out wide and "
            (:substimulate :subtease) "."]
           ["Watching yourself in a mirror "
            (:subspank :subtease :substimulate) "."])

    :substimulate ["play " :stimulate*]
    :stimulate* ["with your genitals " ("very lightly" "rough and fast")]

    :punish (:spank :pinch)

    :spank ["Spank yourself " :spank*]
    :subspank ["spank yourself " :spank*]
    :spank* [:roughness " " (10 20 50) " times"]

    :pinch ["Pinch your nipples " :roughness " for " (1 3 5) " minutes."]

    :finish ["Begin to stimulate yourself more. You must play with yourself for "
             (5 10 20)
             " minutes " (:cum :edge)]

    :cum ["before you are allowed to cum!"]

    :edge ["but you are not allowed to cum! Wait "
           (0 15 30 60) " minutes before trying this again."]})

(def default-grammar-str (str default-grammar))
