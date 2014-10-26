# coding=utf8

from Chapter1.Problem3.PermutationsEqual import PermutationsEqual as PE
from parameterizedtestcase import ParameterizedTestCase


class PermutationsEqual_Test(ParameterizedTestCase):
    test_list = [
        ("aba", "baa", True),
        ("aaa", "aaa", True),
        ("", "", True),
        ("a", "a", True),
        ("aab", "baa", True),
        ("aabc", "baac", True),
        ("ab", "cb", False),
        ("aaba", "aab", False),
        ("bbb", "aaa", False)
    ]

    @ParameterizedTestCase.parameterize(
        ("string_a", "string_b", "expected"), test_list)
    def test_permutations_equal(self, string_a, string_b, expected):
        self.assertEqual(PE.permutations_equal(string_a, string_b), expected)

    def test_pe_raises_exception_with_none_params(self):
        self.assertRaises(AttributeError, PE.permutations_equal, None, None)

    def test_pe_raises_exception_with_none_param_left(self):
        self.assertRaises(AttributeError, PE.permutations_equal, None, "")

    def test_pe_raises_exception_with_none_param_right(self):
        self.assertRaises(AttributeError, PE.permutations_equal, "", None)
