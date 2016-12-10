# Virtual DOM

Virtual DOM is a a program that attempts to explore consent through the lens of computer language.

## A Small Warning

The files contained within the project may or may not be safe for work viewing. Please 
ensure you are in a place where sexually explict language is ok before perusing this project.
I have attempted to keep this read-me as academic as possible, but please be careful, some
suggestive language is definitely contained inside.

## Terms

In the interests of communicating effectively, I offer the following definitions,

* Consent - When this document uses consent, it means enthusiastic consent. This is a continuous
verbal and physical agreement, and an active, mindful approach to ensuring your partner agrees with,
and is excited for the activity.
* Play - The activity through which the Virtual DOM leads the user through. This activity is
defined either by the user, or by the user's partner. As a note, this play does not have to
be sexual in nature. Kink and eroticism are not needed for the core purpose of the app, which
is to help the user explore consent.
* User - This app is intended to facilitate play. The user is the individual
using app for those purposes.
* Dom or Dominant - A dom is one that leads the play. I strive to avoid all the traditional
connotations of dom, which are attributed to other human beings, and not a computer program.
The Virtual DOM is merely intended to lead play.

## Motivation

This project was created to give people a private and controlled way to explore the concept of
consent. The idea was to create a virtual dominant, a computer program that could take the role
of directing play. Before running the computer program, the user defines a
grammar, a set of rules that determine a set of possibilities for how their session will 
proceed. This grammar is non-deterministic, and it can produce a number of different scenarios.

The intent is, that a user will come in, and spend some time learning how to define a grammar. 
A sample grammar is provided, that provides the user some basic instructions on having a cuddling
session with a plush toy. The user is then free to start editing that grammar, testing it, playing
with it, and defining it further. This is the user discussing consent with oneself. It is intended
to be a empowering activity, where, despite the computer program being responsible for deciding
how choices play out, the user is ultimately responsible for their own experience. 

The act of defining a computer language for this is much more difficult than the act of describing
what one actually likes in real life scenarios. This is intentional. It is my hope that the act
of defining this grammar will give the user new ideas on how to speak with real life partners about
these things. It is hoped that the act of debugging and editing the language will allow the user
to explore their own needs, and figure out what they may or may not be into.

Of course, the user does not have to go at it alone. This app can be used with grammars defined by
other people. It is hoped that in the act of defining this complex computer language with a partner,
people will have active discussions with their partners about their interests and likes. It is hoped
that, if partners continue to use the app, and continue to develop the shared language, that
continuous consent will be established. Additionally, the fact that users have to manually upload
the languages, and that they have editorial discretion over those grammars, gives them a safe space
to explore with other people.

## How to Define a Grammar

Virtual DOM grammars are defined in [edn](https://github.com/edn-format/edn).

The grammar is relatively simple.

* The grammar is an edn map. It must contain the key `:->`, which must have a vector associated with it.
  As an example, `{:-> []}`  is the simplest possible Virtual DOM grammar.
* Strings imply text. For example, `"Hello World"` becomes the text _Hello World_ on the page.
* `[]` implies and. For example, `["a " "b " "c"]` becomes the text _a b c_ on the page.
* `()` implies or. For example, `("foo", "bar", "baz")` becomes can become to _foo_ or _bar_ or _baz_ on the page.
  This is randomly selected.
* Keywords imply a look up. For example, `{:-> [:hello-world], :hello-world "Hello World"}` expands to 
  _Hello World_. If the Virtual DOM encounters a keyword, it will check the base grammar for it.

Here is an example grammar, and some of the paths it can go down.

```clojure
{:-> [:eat :sleep "Done!"]
 :eat ["Eat " :food "."]
 :food ("a muffin" "some cereal")
 :sleep ["Sleep " :resting-place "."]
 :resting-place ("on a bed" "on the couch")}
```

This grammar shows off all the features of the grammar. Here are all the possible instructions it can make

```
Eat a muffin. Sleep on a bed. Done!
Eat some cereal. Sleep on a bed. Done!
Eat a muffin. Sleep on the couch. Done!
Eat some cereal. Sleep on the couch. Done!
```

As a note, the Virtual DOM does NOT check for infinite loops of references. This means you can crash the program
by including them. Please be careful!

## Recommendations

I highly suggest defining your own grammar and playing with your own ruleset before playing with
others. The Virtual DOM can be a fun tool for enjoying one's self with other people, and can be used
to facilitate intimate, amorous long distance play. This sort of play is great, but one should ensure
that they know how to understand and edit a grammar before engaging it. This will ensure the user knows
how to comprehend the grammar they are using. After all, one cannot truly consent to one of these
grammars if they do not understand it.

Additionally, I recommend starting out with relatively simple grammars, and building up to something
more complex and generative. If all participating parties have a familiarity with context free grammars
and understand the framework well, it may be possible to start with something more complex, but definitely
start simpler than you think you need to.

## Feature Wishlist

One of the most interesting features that could be implemented is a blacklist, that is, a set of
specific phrases the user explictly does not want to hear. During play, someone may realize they
do not like one of the randomly generated results. Clicking a button should update their grammar
to not include that result. This feature exists, in a sense, because the user can always stop play
to edit the grammar so that the situation does not occur; however, in the interests of imitating more
natural, human ways of dealing with misunderstandings of consent, such a feature would be excellent.

Having some way to save different languages would probably be nice.

## Contact Me

I created this app under the lens of a kinky, pansexual, monoamorous, white male. As such, I do not
have a complete perspective on this work. If you have feature requests that would better facilitate 
your usage of this app, or if you have comments on undesirable or problematic aspects of the work,
please feel free to open a pull request or report a problem. From there, if you'd like to move to
email or some other private channel, I'd be happy to.
