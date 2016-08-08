module Grains (square, total) where


square :: Integer -> Maybe Integer
square n
    | n < 1     = Nothing
    | n > 64    = Nothing
    | otherwise = Just (numGrains n)

total :: Integer
total = sum [numGrains x | x <- [1..64]]

numGrains :: Integer -> Integer
numGrains n = 2 ^ (n - 1)
