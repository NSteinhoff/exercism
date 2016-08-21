module Bob (responseFor) where
import qualified Data.Char as C

responseFor :: String -> String
responseFor hey
    | isNothing  = "Fine. Be that way!"
    | isShouting = "Whoa, chill out!"
    | isQuestion = "Sure."
    | otherwise  = "Whatever."
    where isNothing  = stripped == []
          isShouting = hasLetters && allUpper
          isQuestion = last stripped == '?'
          stripped   = filter (not . C.isSpace) hey
          letters    = filter C.isAlpha hey
          hasLetters = letters /= []
          allUpper   = all C.isUpper letters

