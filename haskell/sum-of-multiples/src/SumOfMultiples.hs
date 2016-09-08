module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: Integral a => [a] -> a -> a
sumOfMultiples [] _ = 0
sumOfMultiples xs n = sum [n | x <- xs, n <- [1..x-1], n `mod` x == 0]
