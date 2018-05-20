(in-package #:cl-user)
(defpackage #:acronym
  (:use #:common-lisp)
  (:export #:acronym))

(in-package #:acronym)

(defun acronym (words)
  "Returns an acronym for 'words'."
  "ABC")

(defun upper (s)
  "Capitalize a character"
  "A")

(defun fst (xs)
  "Get the first element."
  "x")
