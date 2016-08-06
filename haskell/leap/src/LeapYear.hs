{-# LANGUAGE MultiWayIf #-}

module LeapYear where

-- guards: probably the preferred solution
isLeapYear :: Integer -> Bool
isLeapYear x
    | isDivisBy 100 x = isDivisBy 400 x
    | otherwise       = isDivisBy 4 x
    where isDivisBy n x = mod x n == 0


-- guards: using guards to achieve 'early return' or pythons 'elif' syntax
-- I might even prefer this over the first one as there is no nesting at all
-- and it comes closest to how pattern matching is used most of the time
-- to catch the most specific cases first and falling through to the catch-all
-- case at the end
isLeapYear2 :: Integer -> Bool
isLeapYear2 x
    | isDivisBy 400 x = True
    | isDivisBy 100 x = False
    | isDivisBy   4 x = True
    | otherwise       = False
    where isDivisBy n x = mod x n == 0


-- if-then-else: also quite clear
isLeapYear3 :: Integer -> Bool
isLeapYear3 x = if isDivisBy 100 x then isDivisBy 400 x else isDivisBy 4 x
                where isDivisBy n x = mod x n == 0


-- let: doubly nested if condition using guards and where
isLeapYear4 :: Integer -> Bool
isLeapYear4 x
    | x `mod` 4 == 0   = by100
    | otherwise        = False
    where by100 | x `mod` 100 == 0 = x `mod` 400 == 0
                | otherwise        = True


-- let: doubly nested if condition using guards inside let
isLeapYear5 :: Integer -> Bool
isLeapYear5 x =
    let by100 | x `mod` 100 == 0 = x `mod` 400 == 0
              | otherwise        = True
        res   | x `mod` 4 == 0   = by100
              | otherwise        = False
    in res


-- case: matching on result of first condition
-- seems a bit weird
isLeapYear6:: Integer -> Bool
isLeapYear6 x = case x `mod` 100 == 0 of
                    True  -> x `mod` 400 == 0
                    False -> x `mod` 4 == 0


-- case: doubly nested if condition using case and guards
-- super clumsy
isLeapYear7 :: Integer -> Bool
isLeapYear7 x
    | x `mod` 4 == 0 =
        case () of
            _ | x `mod` 100 == 0 ->
                case () of
                    _ | x `mod` 400 == 0 -> True
                      | otherwise        -> False
              | otherwise        -> True
    | otherwise      = False


-- multiWayIf: doubly nested if condition multiWayIf
-- effectively the same as the nested cases, but less ugly
-- needs {-# LANGUAGE MultiWayIf #-} pragma
isLeapYear8 :: Integer -> Bool
isLeapYear8 x = if
    | x `mod` 4 == 0 -> if
        | x `mod` 100 == 0 -> if
            | x `mod` 400 == 0 -> True
            | otherwise        -> False
        | otherwise        -> True
    | otherwise      -> False
