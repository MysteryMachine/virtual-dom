(ns virtual-dom.grammar)

(def default-grammar-str
"{:-> [:pick-friend :cuddle-friend :eat]
 :pick-friend [\"For this cuddle session, find \" :animal \".\"]
 :animal (\"a soft stuffed bear\",
          \"the biggest plush toy you have\")
 :cuddle-friend [\"Cuddle your friend for \" :time :location \".\"]
 :time [(5 10 20) \" minutes \"]
 :location (\"on the couch\",
            \"on your bed\",
            \"wrapped in a blanket\")
 :eat [\"Regain your energy by \" :food \".\"]
 :food (:drink :snack)
 :drink (\"having a cup of tea\"
         \"having a cup of coffee\"
         \"having a glass of water\")
 :snack (\"having a cookie\"
         \"having some carrots\")}")
