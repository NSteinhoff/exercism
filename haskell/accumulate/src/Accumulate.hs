module Accumulate (accumulate) where

-- Using tail recursion
accumulate :: (a -> b) -> [a] -> [b]
accumulate _ [] = []
accumulate f (x:xs) = f x : accumulate f xs

-- I don't see why this is called accumulate, isn't it just map?!
accumulate' :: (a -> b) -> [a] -> [b]
accumulate' = map
