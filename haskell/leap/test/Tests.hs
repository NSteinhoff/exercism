{-# OPTIONS_GHC -fno-warn-type-defaults #-}

import Control.Monad (unless)
import System.Exit   (exitFailure)

import Test.HUnit
    ( (~:)
    , (~=?)
    , Counts (failures, errors)
    , Test   (TestList)
    , runTestTT
    )

import LeapYear

main :: IO ()
main = do
         counts <- runTestTT $ isLeapYearTests isLeapYear
         counts <- runTestTT $ isLeapYearTests isLeapYear2
         counts <- runTestTT $ isLeapYearTests isLeapYear3
         counts <- runTestTT $ isLeapYearTests isLeapYear4
         counts <- runTestTT $ isLeapYearTests isLeapYear5
         counts <- runTestTT $ isLeapYearTests isLeapYear6
         counts <- runTestTT $ isLeapYearTests isLeapYear7
         counts <- runTestTT $ isLeapYearTests isLeapYear8
         unless (failures counts == 0 && errors counts == 0) exitFailure


isLeapYearTests :: (Integer -> Bool) -> Test
isLeapYearTests f = TestList $ map test cases
  where
    test (label, year, expected) = label ~: f year ~=? expected
    cases = [ ("leap year"                  , 1996, True )
            , ("standard and odd year"      , 1997, False)
            , ("standard even year"         , 1998, False)
            , ("standard nineteenth century", 1900, False)
            , ("standard eighteenth century", 1800, False)
            , ("leap twenty fourth century" , 2400, True )
            , ("leap y2k"                   , 2000, True ) ]
