defmodule ElixirCode.Chapter1.Problem3 do
  @moduledoc """
  Given two strings, write a method to decide if one is a permutation
  of the other.
  """

  @spec is_permutation(String.t, String.t) :: boolean
  def is_permutation("", ""), do: true
  def is_permutation(str_a, str_b) when (is_bitstring str_a) and (is_bitstring str_b) do
    cond do
      (String.length str_a) == (String.length str_b) -> _get_charmap(str_a) == _get_charmap(str_b)
      true -> false
    end
  end

  defp _get_charmap(str, map \\ %{})
  defp _get_charmap(str, map) when is_bitstring(str), do: _get_charmap((to_charlist str), map)
  defp _get_charmap([], map), do: map
  defp _get_charmap([h|t], map) do
    case Map.get(map, h, 0) do
      0 -> _get_charmap t, (Map.put map, h, 1)
      val -> _get_charmap t, (Map.put map, h, val+1)
    end
  end
end
