module Sublist (Sublist(..), sublist) where
import Data.List (isInfixOf)

-- The task is to create the data type `Sublist`, with `Eq` and
-- `Show` instances, and implement the function `sublist`.

data Sublist = Sublist | Superlist | Equal | Unequal deriving (Eq, Show)

sublist :: (Eq a) => [a] -> [a] -> Sublist
sublist xs ys
    | xs == ys          = Equal
    | xs `isInfixOf` ys = Sublist
    | ys `isInfixOf` xs = Superlist
    | otherwise         = Unequal
