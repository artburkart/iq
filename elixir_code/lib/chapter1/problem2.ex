defmodule ElixirCode.Chapter1.Problem2 do
  @moduledoc """
  Write code to reverse a C-Style String. (C-String means that “abcd”
  is represented as five characters, including the null character.)
  """

  @compile :no_active

  @doc """
  Returns the reverse of a given string.

  ## Examples

    iex> reverse_string("abcd")
    "dcba"
  """
  @spec reverse_string(String.t) :: String.t
  def reverse_string(str) when (is_bitstring str), do: _reverse_string (to_charlist str)

  @spec _reverse_string([char]) :: String.t
  defp _reverse_string(charlist, result \\ '')
  defp _reverse_string([h|t], result), do: _reverse_string t, [h|result]
  defp _reverse_string([], result), do: to_string result
end
