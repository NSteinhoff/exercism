.PHONY: test

test: test-stamp

test-stamp: $(shell find . -name '*.clj')
	@lein test
	@touch @$
